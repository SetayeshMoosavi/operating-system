package com.company;

import java.util.concurrent.Semaphore;

public class eight {
    Semaphore car_lock = new Semaphore(4);
    Semaphore truck_lock = new Semaphore(1);
    Semaphore access = new Semaphore(1);
    Semaphore priority= new Semaphore(1);
    int count = 0;
    String id;

    public void In() {
        if (id == "car") {
            priority.acquire();
            car_lock.acquire();
            access.acquire();
            count++;
            access.release();
        }
        if (id = "truck") {
            priority.acquire();
            while( count!=0) {
                truck_lock.acquire();
            }
        }

        public void Out(){
            if (id=="car"){
                access.acquire();
                count--;
                car_lock.release();
                access.release();
            }
            if (id=="truck"){
                truck_lock.release();
                priority.release();
            }
}
