package shopping.pricing;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Logger;

import shopping.core.Basket;
import shopping.core.Item;
import shopping.core.Product;
import shopping.core.ProductDetails;

public class ShopInHenrysGrocery {

    private static final Logger LOGGER = Logger.getLogger(ShopInHenrysGrocery.class.getName());
    
    public static void main(String rags[]) throws InterruptedException {

        final Item apple = new Product(ProductDetails.APPLES.getProductName(), ProductDetails.APPLES.getCostInPounds());
        final Item soup = new Product(ProductDetails.SOUP.getProductName(), ProductDetails.SOUP.getCostInPounds());
        final Item bread = new Product(ProductDetails.BREAD.getProductName(), ProductDetails.BREAD.getCostInPounds());
        final Item milk = new Product(ProductDetails.MILK.getProductName(), ProductDetails.MILK.getCostInPounds());

        LOGGER.info("********* Welcome to HenrysGrocery **** ");
        Thread.sleep(500);
        LOGGER.info("********* Available Grocery ****** " );
        LOGGER.info("\n"
                        +" |-------------------------|\n "
                        +"| Product | Unit   | Cost |\n"
                        +" |-------------------------|\n "
                        +"| soup    | tin    | 0.65 |\n"
                        +" | bread   | loaf   | 0.80 |\n"
                        +" | milk    | bottle | 1.30 |\n"
                        +" | apples  | single | 0.10 |\n"
                        +" |-------------------------|\n"
                        +"Discounts\n"
                        +"|------------------------------------------------------------------------------------------------------------------------------|\n"
                        +"| the offer                                                |        valid from         |                            valid to   |\n"
                        +"|------------------------------------------------------------------------------------------------------------------------------|\n"
                        +"| Buy 2 tins of soup and get a loaf of bread half price    |        yesterday          |                            for 7 days |\n"
                        +"|------------------------------------------------------------------------------------------------------------------------------|\n"
                        +"| Apples have a 10% discount                               |        from 3 days hence  |  until the end of the following month |\n"
                        +"|------------------------------------------------------------------------------------------------------------------------------| ");
        Thread.sleep(500);
        final Scanner scanner = new Scanner(System.in);
        final Basket Basket = new Basket();

        LOGGER.info("Enter purchaseDate in YYYY-MM-DD format only : ");
        final String purchaseDate = scanner.next();
        final LocalDate localDate = LocalDate.parse(purchaseDate);
        LOGGER.info("Enter number of Soup tins : ");
        final int soupCount = scanner.nextInt();
        Basket.add(soup, soupCount);

        LOGGER.info("Enter number of Bread loaf's : ");
        final int breadCount = scanner.nextInt();
        Basket.add(bread, breadCount);

        LOGGER.info("Enter number of Milk bottle : ");
        final int milkCount = scanner.nextInt();
        Basket.add(milk, milkCount);

        LOGGER.info("Enter number of Apples : ");
        final int appleCount = scanner.nextInt();
        Basket.add(apple, appleCount);
        LOGGER.info("    HenrysGrocery-Bill      ");
        LOGGER.info(Basket.toString(localDate));

    }
}
