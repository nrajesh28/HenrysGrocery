package shopping.core;

public interface Item {
    double unitPrice();
    double priceForQuantity(int quantity);
    String description();
}