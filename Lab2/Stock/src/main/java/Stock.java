public class Stock {

    private String name;
    private int quantity;

    public Stock(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

}
