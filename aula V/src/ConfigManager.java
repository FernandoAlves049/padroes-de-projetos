import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class ConfigManager {
    private static ConfigManager instance;
    private Properties props;

    private ConfigManager() {
        props = new Properties();
        try {
            props.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            /* Tratamento de erro */
            e.printStackTrace();
        }
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            synchronized (ConfigManager.class) {
                if (instance == null) {
                    instance = new ConfigManager();
                }
            }
        }
        return instance;
    }

    public String getProperty(String key) {
        return props.getProperty(key);
    }
}
