package com.company;

import java.util.concurrent.Semaphore;

public class seven {
    Semaphore car_lock = new Semaphore(4);
    Semaphore truck_lock = new Semaphore(1);
    Semaphore access = new Semaphore(1);
    int count = 0;
    String id;

    public void In() {
        if (id == "car") {
            car_lock.acquire();
            access.acquire();
            count++;
            access.release();
        }
        if (id = "truck") {
            while (count != 0) {
                car_lock.acquire(); //to avoid entering any new car
                truck_lock.acquire();
            }
        }
    }

    public void Out() {
            if (id == "car") {
                access.acquire();
                count--;
                car_lock.release();
                access.release();
            }
            if (id == "truck") {
                truck_lock.release();
                car_lock.release();
            }
    }
}
