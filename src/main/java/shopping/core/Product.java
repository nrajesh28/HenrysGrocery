package shopping.core;

public class Product implements Item {

    private final String description;
    private final double unitPrice;

    public Product(String description, double priceInCents) {
        this.description = description;
        this.unitPrice = priceInCents;
    }

    public double unitPrice() {
        return unitPrice;
    }

    public String description() {
        return description;
    }

    public double priceForQuantity(int quantity) {
        return unitPrice * quantity;
    }
}
