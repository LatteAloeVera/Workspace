package Code;
public class App {
    public static void main(String[] args) throws Exception {
        ConfigManager manager = ConfigManager.getInstance();
        
        manager.loadProperties("src/Code/config.properties");
        System.out.println(manager.getProperty("dbURL"));

        manager.setProperty("dbURL", "XXX");
        System.out.println(manager.getProperty("dbURL"));


    }
}
