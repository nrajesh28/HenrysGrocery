package shopping.pricing;

import java.time.LocalDate;

import shopping.core.ProductDetails;

public class PromotionPricing  {


    public static double applyDiscountOnBread(final int soupTinCount, final int totalBreadInBasket) {
        double priceAfterDiscount = 0;
        int breadCountEligibleForDiscount = totalBreadEligibleForDiscount(soupTinCount);
        int temp = totalBreadAppliedDiscount(breadCountEligibleForDiscount, totalBreadInBasket);
        for (int i = 0; i < temp; i++) {
            priceAfterDiscount = priceAfterDiscount + (ProductDetails.BREAD.getCostInPounds() / 2);
        }
        if(totalBreadInBasket-temp > 0 )
            priceAfterDiscount = priceAfterDiscount+ProductDetails.BREAD.getCostInPounds()*(totalBreadInBasket-temp);
        return priceAfterDiscount;
    }

    public static double applyDiscountOnApples(final int applesCount) {
        return applesCount * (ProductDetails.APPLES.getCostInPounds() - (ProductDetails.APPLES.getCostInPounds() * 0.1));
    }

    public static boolean isWithinRangeForSoup(LocalDate testDate) {
        return !(testDate.isBefore(LocalDate.now().minusDays(1)) || testDate.isAfter(LocalDate.now().plusDays(7)));
    }

    public static boolean isWithinRangeForApples(LocalDate testDate) {
        return !(testDate.isBefore(LocalDate.now().minusDays(3)) || testDate.isAfter(LocalDate.now().plusDays(30)));
    }

    public static int totalBreadEligibleForDiscount(final int soupTins) {
        return soupTins / 2;
    }

    public static int totalBreadAppliedDiscount(final int totalBreadEligible, final int totalAddedInBasket) {
        return (totalBreadEligible <= totalAddedInBasket) ? totalBreadEligible : totalAddedInBasket;
    }


}