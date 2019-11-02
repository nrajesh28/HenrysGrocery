package shopping.core;

import static shopping.pricing.PromotionPricing.applyDiscountOnApples;
import static shopping.pricing.PromotionPricing.applyDiscountOnBread;
import static shopping.pricing.PromotionPricing.isWithinRangeForApples;
import static shopping.pricing.PromotionPricing.isWithinRangeForSoup;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;


public class Basket {

    private Map<Item, Integer> quantities;
    private static final Logger LOGGER = Logger.getLogger(Basket.class.getName());

    public Basket() {
        quantities = new LinkedHashMap<Item, Integer>();
    }


    public double total(final LocalDate localDate) {
        double result = 0;
        for (Item each : quantities.keySet()) {
            if (each.description().equals(ProductDetails.APPLES.getProductName()) && isWithinRangeForApples(localDate)) {
                LOGGER.info("Discount applied for APPLES");
                result += applyDiscountOnApples(quantities.get(each));
            } else if (each.description().equals(ProductDetails.BREAD.getProductName()) && isWithinRangeForSoup(localDate)) {
                LOGGER.info("Discount applied for BREAD");
                result += applyDiscountOnBread(getParentItemCount(), quantities.get(each));
            } else {
                result += each.priceForQuantity(quantities.get(each));
            }
        }
        return result;
    }

    public double total() {
        double result = 0;
        for (Item each : quantities.keySet()) {
            result += each.priceForQuantity(quantities.get(each));
        }
        return result;
    }

    public void add(Item itemToBuy) {
        add(itemToBuy, 1);
    }

    public void add(Item itemToBuy, int howMany) {
        int previousQuantity = quantities.containsKey(itemToBuy)
                ? quantities.get(itemToBuy)
                : 0;
        quantities.put(itemToBuy, previousQuantity + howMany);
    }

    public String toString(final LocalDate localDate) {
        String line = "--------------------------------\n";
        StringBuffer sb = new StringBuffer();
        sb.append(line);
        for (Item each : quantities.keySet()) {
            sb.append(String.format("%-15s% 7.2f %-5s", each.description(), each.unitPrice(), "X"));
            sb.append(quantities.get(each));
            sb.append(String.format("%5s %2.2f\n", "=", each.unitPrice() * quantities.get(each)));
        }
        sb.append(line);
        sb.append(String.format("%24s% 8.2f", "TOTAL:", total(localDate)));
        return sb.toString();
    }

    private Integer getParentItemCount() {
        for (Item each : quantities.keySet()) {
            if (each.description().equals(ProductDetails.SOUP.getProductName())) {
                return quantities.get(each);
            }
        }
        return null;
    }
}