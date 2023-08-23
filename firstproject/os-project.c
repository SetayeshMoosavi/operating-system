#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <math.h>
#include <sys/wait.h>
#include <sys/mman.h>
#include <time.h>

int main()
{
    clock_t begin = clock();

    int A[]={1,2,3,4,5,6};
    int list[200][200];
    int PID[200];
    int B[20];
    int n= sizeof(A) / sizeof(int);
    int k=3 ;
    int z=(n/k);
    int j=0;
    int i=0;
    int f=0;
    for (i;i<k;i++){
        if (i!=k-1){
            int w=0;
            for (j;j<f+z;j++){
                list[i][w]=A[j];
                w++;
            }
            j=j+z-1;
            f=j+z-1;
        }
        else{
            j=j-z+1;
            int w=0;
            for(j;j<=n;j++){
                list[k-1][w]=A[j];
                w++;

            }
        }
    }
    //our first list A is divided
    int L[2];
    pipe(L);
    //we opened a pipe

    int lpID=0;
    PID[0]=fork();

    
    for (i=1,i<i+1,i++){
        int m= sizeof(PID) / sizeof(int);
        lpID++;
        if (lpID==m){
            if (PID[m-1]==0){
                B=list[0];
            }
            for (a=0,a<m-1,a++){
                list[a]=list[a+1];
                //in this for we delete first item in the list
            }
            if ( int(sizeof(list) / sizeof(int))==0 ){
                break;
            }
            PID[i]=fork();
    }
    //all the cildren are made and they have their selected part of our A list
    if (PID[0]==0){
        int C[200];
        while (int(sizeof(B)/sizeof(int))!=2 ){
           int b= ( (sizeof(B)/sizeof(int) )/2;
           PID[k]=fork();
           if (PID[k]==0);{
               for (i=0,i<=b,i++){
                   C[i]=B[i];
               }
               B=C
               //we update the list B
           }
           else{
               for (i=b+1,b< int(sizeof(B)/sizeof(int)), i++){
                   C[i]=B[i];
               }
               B=C
           }
           k++;
        }
        // our children come out of while when the lenght of B is 2 or less than that
        if( int(sizeof(B)/sizeof(int))==2 ){
            int temp=0;
            if B[0]>B[1]{
                temp=B[0];
                B[0]=B[1];
                B[1]=temp;
            }
            close(L[0]);
            write(L[1], &B,sizeof(int));
            close(L[1]);
        }
        else{
            // if the lenght is equal to 1
            close(L[0]);
            write(L[1], &B,sizeof(int));
            close(L[1]);
        }
        int H[200];
        for (i=sizeof(PID)/sizeof(int))-1, i=0,i--){
            if (PID[i]!=0){
                //the parent should wait for the children first
                wait(NULL);
                read(L[0], &H, sizeof(int));
                close(L[0]);
                h=sizeof(H)/sizeof(int);
                s=sizeof(B)/sizeof(int);
                int final[b+h];
                int o=0;
                for (i=0;i<h; i++)
                {
                    for (j=0;j<s;j++)
                    {
                        if (H[i]<B[j]){
                            final[o]=H[i];
                            o++;
                            break();
                        }
                        else{
                            final[o]=B[j];
                        }
                        o++;
                    }
                    
                }
                write(L[1], final, sizeof(int));
                close(L[1]);
            }
           
        }
    }
    else{
        int FINAL[200];
        //we are in p0 
        wait(NULL);
        //the main parent should wait till all the children are finished
        close(L[1]);
        read(L[0],FINAL, sizeof(int));
        printf("the answer is: %d", FINAL);
        v=sizeof(FINAL)/sizeof(int);
        int e= int(v/4);
        int q=int (v/2);
        printf("first quarter: %d",FINAL[q-e-1]);
        printf("second quarter: %d",FINAL[q]);
        printf("third quarter: %d",FINAL[q+e+1]);
        //second part of the project, im gonna use shared memory:
        void *shared_memory( size_t size) {
            int protection = PROT_READ | PROT_WRITE;
            int visibility = MAP_SHARED | MAP_ANONYMOUS;
            return mmap(NULL, size, protection, visibility, -1, 0);
            }
        int sum=0;
        p2=fork();
        if (p2==0){
            p3=fork();
            if (p3==0);{
                for (i=0,i<n,i++){
                    sum=sum+ A[i];
                }
                void *shmem =shared_memory(1024);
                memcpy(shmem,sum,sizeof(sum));
                //the child shared the amount of sum and its stored in shmem
            }
            else{
                //first we should wait for the child to give us the sum
                wait(NULL);
                int sum2=0;
                for (i=0,i<n,i++){
                    sum2=sum2+ pow( (A[i]-int(shmem)),2);
                }
                print("variance is %d", sum2/n);
            }
        }
    }
    clock_t end = clock();
    double time_spent = (double)(end - begin) / CLOCKS_PER_SEC;
    printf("time: %lf", time_spent);
    return 0;
}