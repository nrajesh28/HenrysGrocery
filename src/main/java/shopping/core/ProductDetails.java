package shopping.core;

public enum ProductDetails {

    SOUP("soup", "tin", 0.65),
    BREAD("bread", "loaf", 0.80),
    MILK("milk", "bottle", 1.30),
    APPLES("apples", "single", 0.10);

    private final String productName;
    private final String unitType;
    private final double costInPounds;


     ProductDetails(final String productName, final String unitType, final double costInPounds) {
        this.productName = productName;
        this.unitType = unitType;
        this.costInPounds = costInPounds;
    }

    public String getProductName() {
        return productName;
    }

    public String getUnitType() {
        return unitType;
    }

    public double getCostInPounds() {
        return costInPounds;
    }


}
