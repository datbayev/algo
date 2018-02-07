package algorithms.threads;

public class Deadlock {
    static class Friend {
        public String name;

        Friend(String name) {
            this.name = name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s has bowed to me%n", this.name, bower.name);
            bower.bowBack(bower);
        }

        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s has bowed back to me%n", this.name, bower.name);
        }
    }

    public static void main(String[] args) {
        Friend alibek = new Friend("alibek");
        Friend zhanibek = new Friend("zhanibek");

        new Thread(() -> alibek.bow(zhanibek)).start();
        new Thread(() -> zhanibek.bow(alibek)).start();
    }
}
