import java.util.ArrayList;

public class StockPortfolio {

    private String name;
    private IStockMarket MarketService;
    private ArrayList<Stock> stock = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public IStockMarket getMarketService() {
        return MarketService;
    }

    public void setMarketService(IStockMarket newMarketService) {
        MarketService = newMarketService;
    }

    public double getTotalValue() {

        double wallet = 0;

        for(Stock s: this.stock){
            wallet += MarketService.getPrice(s.getName()) * s.getQuantity();
        }

        return wallet;

    }

    public void addStock(Stock newStock) {
        this.stock.add(newStock);
    }
}
