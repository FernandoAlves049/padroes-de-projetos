public class App {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new DatabaseAccessThread("Thread-DB-" + (i + 1));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Todas as threads finalizaram.");
    }
}
