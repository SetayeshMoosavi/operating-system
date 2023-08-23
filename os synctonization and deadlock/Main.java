//problem number 4
package com.company;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main {
    public class Resource {
        private static long idGenerator = 1L;
        private final Long id;
        public Resource() {
            this.id = idGenerator++;
        }
        public void useResource() {
            final String uid = UUID.randomUUID().toString();
            final String str = ThreadLocalRandom
                    .current().nextBoolean() ? "####" : ThreadLocalRandom
                    .current().nextBoolean() ? "$$$$$$" : "@";
            System.out.println(str + " Using Resource with ID= "
                    + id + " Started at " + System.nanoTime()
                    + " Call ID = " + uid + " " + str);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(str + " Using Resource with ID= "
                    + id + " Ended at " + System.nanoTime()
                    + " Call ID = " + uid + " " + str);
        }
    }

    public class ResourcePool{
        private List<Resourse> resourses;
        Semaphore lock = new Semaphore(1);

        public ResourcePool(int initialSize) {
            resourses= new ArrayList<>();
            for (int i=0; i<initialSize; i++){
                resourses.add(new Resourse());
            }
        }
        public void useResource() {
            lock.acquire();
            Resourse src= resourses.remove(0);
            src.useResourse();
            resourses.add(src);
            lock.release();
        }
    }
}
