package com.company;

import java.util.concurrent.Semaphore;

public class nine {
    Semaphore car_lock = new Semaphore(4*n);
    Semaphore truck_lock = new Semaphore(n);
    Semaphore access = new Semaphore(1);
    int count = 0;
    String id;
    int n;

    public void In() {
        if (id == "car") {
            car_lock.acquire();
            access.acquire();
            count++;
            if (count%4==1){
                truck_lock.acquire();
            }
            access.release();
        }
        if (id = "truck") {
            truck_lock.acquire();
            }
        }
    }

    public void Out() {
        if (id == "car") {
            access.acquire();
            if (count%4==1) {
                truck_lock.release();
            }
            count--;
            car_lock.release();
            access.release();
        }
        if (id == "truck") {
            truck_lock.release();
        }
    }
}
