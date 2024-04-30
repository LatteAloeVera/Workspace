import java.lang.reflect.Array;
import java.util.ArrayList;

public class StoreManager {
    private static StoreManager instance = null;

    private double todaysIncome;
    private int todaysSellCount;
    private double totalIncome;
    private int totalSellCount;

    private ArrayList<Stock> allStocks;
    


    private StoreManager() {
        this.todaysIncome = 0;
        this.todaysSellCount = 0;
        this.totalIncome = 0;
        this.totalSellCount = 0;
        this.allStocks = new ArrayList<Stock>();

    };

    protected static StoreManager getInstance() {
        if (StoreManager.instance == null) {
            instance = new StoreManager();
        }

        return StoreManager.instance;
    }

    public void addNewStock() {
        
    }

    
}
