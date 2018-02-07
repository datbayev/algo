package algorithms.threads;

public class InterleavedThreads {

    public static void main(String[] args) throws InterruptedException {
        OddEvenMonitor monitor = new OddEvenMonitor();

        Thread t1 = new EvenThread(monitor);
        Thread t2 = new OddThread(monitor);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    static class OddEvenMonitor {
        public static final boolean ODD_TURN = true;
        public static final boolean EVEN_TURN = false;

        private boolean turn = ODD_TURN;

        public synchronized void waitTurn(boolean oldTurn) {
            while (turn != oldTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Continue working, now it's our turn
        }

        public synchronized void toggleTurn() { // synchronized is for the sake of notfiy()
            turn ^= true;
            notify();
        }
    }

    static class EvenThread extends Thread {
        private final OddEvenMonitor monitor;

        EvenThread(OddEvenMonitor monitor) {
            this.monitor = monitor;
        }

        @Override
        public void run() {
            for (int i = 2; i <= 100; i += 2) {
                monitor.waitTurn(OddEvenMonitor.EVEN_TURN);
                System.out.println("even! i=" + i);
                monitor.toggleTurn();
            }
        }
    }

    static class OddThread extends Thread {
        private final OddEvenMonitor monitor;

        OddThread(OddEvenMonitor monitor) {
            this.monitor = monitor;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 100; i += 2) {
                monitor.waitTurn(OddEvenMonitor.ODD_TURN);
                System.out.println("odd! i=" + i);
                monitor.toggleTurn();
            }
        }
    }
}
