public class StoreManager {
    private static StoreManager instance = null;

    private double todaysIncome;
    private int todaysSellCount;
    private double totalIncome;
    private int totalSellCount;
    


    private StoreManager() {
        this.todaysIncome = 0;
        this.todaysSellCount = 0;
    };

    protected static StoreManager getInstance() {
        if (StoreManager.instance == null) {
            instance = new StoreManager();
        }

        return StoreManager.instance;
    }

    
}
