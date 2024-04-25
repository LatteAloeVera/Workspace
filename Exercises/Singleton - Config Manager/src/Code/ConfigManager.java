package Code;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class ConfigManager {
    private Properties properties;
    private static ConfigManager instance = null;

    private ConfigManager() {
        this.properties = new Properties();
    }
    
    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }
    
    public void loadProperties(String filePath) {
        if (filePath != null) {
            try {
                this.properties.load(new FileInputStream(filePath));
            } catch (FileNotFoundException e) {
                System.out.println("Exception: " + e.getMessage());
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public String getProperty(String key) {
        if (this.properties.containsKey(key)) {
            return this.properties.getProperty(key);
        }

        return null;
    }

    public void setProperty(String key, String value) {
        if (this.properties.containsKey(key)) {
            this.properties.setProperty(key, value);
        } else {
            System.out.println("Invalid key value!");
        }
    }
    

    
}
