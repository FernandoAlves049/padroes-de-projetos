public class DatabaseConnectionManager {
    private static volatile DatabaseConnectionManager instance;

    private DatabaseConnectionManager() {
        System.out.println("Gerenciador de conexão criado uma única vez.");
    }

    public static DatabaseConnectionManager getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnectionManager.class) {
                if (instance == null) {
                    instance = new DatabaseConnectionManager();
                }
            }
        }
        return instance;
    }

    public synchronized void executeQuery(String threadName) {
        System.out.println(threadName + " usando conexão " + System.identityHashCode(this));
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(threadName + " foi interrompida.");
        }
        System.out.println(threadName + " finalizou operação no banco.");
    }
}
