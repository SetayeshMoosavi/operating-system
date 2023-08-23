package com.company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class six_with_monitor {
    private int count = 0;
    private Lock lock= new ReentrantLock();
    int n;
    String text;

    while (count<n){
        lock.lock();
        count++;
        lock.unlock();
        System.out.println(String text);
        lock.lock();
        count--;
        lock.unlock();
    }
}
