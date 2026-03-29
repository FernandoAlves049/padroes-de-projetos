public class DatabaseAccessThread extends Thread {
    public DatabaseAccessThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        DatabaseConnectionManager manager = DatabaseConnectionManager.getInstance();
        manager.executeQuery(getName());
    }
}
