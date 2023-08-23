package com.company;

import java.util.concurrent.Semaphore;

public class six {
    Semaphore semaphore = new Semaphore(n);
    int n;
    String text;
    public void In(){
        semaphore.acquire();
        System.out.println(String text);
        semaphore.release();
    }
}
