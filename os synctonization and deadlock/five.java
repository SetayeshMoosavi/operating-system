package com.company;

import java.util.List;
import java.util.concurrent.Semaphore;

public class five {
    public class Player extends Thread {
        private final String name;
        private final Server server;

        public Player(String name, Server server) {
            this.name = name;
            this.server = server;
        }
        @Override
        public void run(){
            System.out.println("player {" + name + "} is trying to join server!");
            int id = server.join(this);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(2000,10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            server.ready(id);
            System.out.println("|| player with name " + name + " is ready!");
        }

        public void startGame(){
            System.out.println("Player " + name + "startedGame");
        }
    }
    public class Server implements Runnable{
        private int players;
        private List<Player> players;
        Semaphore barrier =new Semaphore(0);
        int count=0;
        String a= 'False';
        public Server(int lobbySize){
            players = lobbySize;
        }
        @Override public void run() {
            if (a=='True') {
                startGame();
            }
        }
        public int join(Player player){
            int id = 0;
            Semaphore lock = new Semaphore(1);
            lock.acquire();
            id= idGenerator++;
            players.add(player);
            System.out.println("-> player {" + player.getName() + "} is joining server!");
            return id;
        }
        public void ready(int id){
            Semaphore semaphore= new Semaphore(1);
            semaphore.acquire();
            count++;
            if (count==playersNo){
                barrier.release();
                a='True';
            }
            semaphore.release();
            barrier.acquire();
            a='True';
            run();
            barrier.release();
        }
    }
}
