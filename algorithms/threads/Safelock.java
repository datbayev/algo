package algorithms.threads;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Safelock {
    final public static class Friend {
        String name;

        private final Lock lock = new ReentrantLock();

        Friend(String name) {
            this.name = name;
        }

        public boolean impendingBow(Friend bower) { // ~upcoming
            Boolean myLock = false;
            Boolean yourLock = false;

            try {
                myLock = lock.tryLock();
                yourLock = bower.lock.tryLock();
            } finally {
                if (! (myLock && yourLock)) { // can't bow, something is locked
                    if (myLock) {
                        lock.unlock();
                    }

                    if (yourLock) {
                        bower.lock.unlock();
                    }
                }
            }

            return myLock && yourLock;
        }

        public void bow(Friend bower) {
            if (impendingBow(bower)) {
                try {
                    System.out.format("%s: %s has bowed to me! %n", this.name, bower.name);
                    bower.bowBack(this);
                } finally {
                    lock.unlock();
                    bower.lock.unlock();
                }
            } else {
                System.out.format("%s: %s started bowing to me, but saw that I was already bowing to him. %n", this.name, bower.name);
            }
        }

        public void bowBack(Friend bower) {
            System.out.format("%s: %s has bowed back to me. %n", this.name, bower.name);
        }
    }

    static class BowLoop implements Runnable {

        private Friend bower;
        private Friend bowee;

        public BowLoop(Friend bower, Friend bowee) {
            this.bower = bower;
            this.bowee = bowee;
        }

        public void run() {
            Random rand = new Random();

            while (true) {
                try {
                    Thread.sleep(rand.nextInt(5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                bowee.bow(bower); // the actual action of bowing
            }
        }
    }

    public static void main(String[] args) {
        final Friend alibek = new Friend("alibek");
        final Friend zhanibek = new Friend("zhanibek");

        new Thread(new BowLoop(alibek, zhanibek)).start();
        new Thread(new BowLoop(zhanibek, alibek)).start();
    }
}
