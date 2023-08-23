package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
private static long idGenerator = 1;

public class Main {
    Semaphore semaphore1 = new Semaphore(1);
    Semaphore semaphore2 = new Semaphore(1);
    Semaphore semaphore3 = new Semaphore(1);
    Semaphore semaphore4 = new Semaphore(1);
    Semaphore semaphore5 = new Semaphore(1);
    Semaphore semaphore6 = new Semaphore(1);
    Semaphore semaphore7 = new Semaphore(1);
    //assume we have only 7 topics
    public static Arrays array = new ArrayList<>();
    array=[semaphore1,semaphore2,semaphore3,semaphore4,semaphore5,semaphore6,semaphore7];
    public static String Topic;
    public static String M;
    Semaphore lock1 = new Semaphore(1);
    public static Queue<String> q1 = new LinkedList<>();
    public static Queue<String> q2 = new LinkedList<>();
    public static Queue<String> q3 = new LinkedList<>();
    public static Queue<String> q4 = new LinkedList<>();
    public static Queue<String> q5 = new LinkedList<>();
    public static Queue<String> q6 = new LinkedList<>();
    public static Queue<String> q7 = new LinkedList<>();
    public static Dictionary D3 = new Hashtable();
    D3=[topic1:q1, topic2:q2,topic3:q3,topic4:q4,topic5:q5,topic6:q6,topic7:q7];
    public static Queue<String> q8 = new LinkedList<>();
    public static Queue<String> q9 = new LinkedList<>();
    public static Queue<String> q10 = new LinkedList<>();
    public static Queue<String> q11= new LinkedList<>();
    public static Queue<String> q12= new LinkedList<>();
    public static Queue<String> q13= new LinkedList<>();
    public static Queue<String> q14= new LinkedList<>();
    public static Dictionary D4 = new Hashtable();
    D4=[topic1:q8, topic2:q9,topic3:q10,topic4:q11,topic5:q12,topic6:q13,topic7:q14];
    public static Dictionary D1 = new Hashtable();
    public static Dictionary D2 = new Hashtable();
    public static Dictionary Messages = new Hashtable();
    public static File topic = new File("file.txt");
    public static File message = new File("file.txt");
    public static File my_file = new File("data.txt");
    FileWriter my_file= new FileWriter(name);
    public static String name= my_file.getName();
}

public class GetLine {
    public String randomLine(file) throws FileNotFoundException {
        String result = null;
        Random rand = new Random();
        int n = 0;
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            n++;
            String line = sc.nextLine();
            if (rand.nextInt(n) == 0)
                result = line;
        }
        sc.close();
        return result;
    }
}

public class Publisher {
    public  void run()throws FileNotFoundException{
        Topic=GetLine.randomline(topic);
        M=GetLine.randomline(message[Topic]);
        D3.keys(Topic).add(M);
        D1.put(Topic, D3.keys(Topic));
        Thread.sleep(100);
        new Thread(new Runnable() {
            public void run() {
                Subscriber.run();
            }
        }
        ).start();
    }
}

public class Subscriber {
    public void run() throws FileNotFoundException {
        List =[];  //all the topics each subsctiber wants
        int id;
        id = idGenerator++;
        for (String item : List) {
            D4.keys(item).add(id);
            D2.put(item, D4.keys(item));
        }
        public void print_my_message (String mmesage,int id) throws FileNotFoundException {
            System.out.println("message is :", mmessage, "from thread with id:", id);
            lock1.acquire();
            my_file.delete(mmessage);
            lock1.release();
        }
    }
}

public class Write {
    public static void main(String a) {
        try {
            my_file.write(String a);
            my_file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Message_broker{
    String message2;
    for (i=0;i<lenght(D1.keys()),i++){
        array[i].acquire();
        String h=D1.keys(i);
        Messages.keys(h)=D1.keys(h);
        D1.remove(h);
        array[i].release();
    }
    for (String item : Messages.keys()){
        message2 = Messeges.key(item);
        Messages.remove(item);
        lock1.acquire();
        Write(message2);
        lock1.release();
        if (isEmpty(D2.keys(item))){
            array[index(item)].acquire();
            Messages.put(item, message2);
        }
        else{
            array[index(item)].release();
            Ip = D2.keys(item);
            Subscriber.print_my_message(message2, Ip);
            D2.keys(item).remove(Ip);
        }
    }
}