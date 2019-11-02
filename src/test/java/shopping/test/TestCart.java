package shopping.test;

import org.junit.Before;
import org.junit.Test;
import shopping.core.Basket;
import shopping.core.Item;
import shopping.core.Product;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

public class TestCart {

    private Basket basket;
    private Item soup, bread, milk, apples;

    @Before
    public void setUp() {
        basket = new Basket();
        soup = new Product("soup", 0.65);
        bread = new Product("bread", 0.80);
        milk = new Product("milk", 1.30);
        apples = new Product("apples", 0.10);
    }

    @Test
    public void test_printEmpty() {
        assertEquals("--------------------------------\n" +
                "--------------------------------\n" +
                "                  TOTAL:    0.00", basket.toString(LocalDate.now()));
    }

    @Test
    public void test_printOneOfEach() {
        basket.add(soup,10);
        basket.add(bread,20);
        basket.add(milk,30);
        basket.add(apples,40);
        assertEquals("--------------------------------\n" +
                "soup              0.65 X    10    = 6.50\n" +
                "bread             0.80 X    20    = 16.00\n" +
                "milk              1.30 X    30    = 39.00\n" +
                "apples            0.10 X    40    = 4.00\n" +
                "--------------------------------\n" +
                "                  TOTAL:   63.10", basket.toString(LocalDate.now()));
    }

    @Test
    public void test_printOneOfEach2() {
        basket.add(soup,10);
        basket.add(bread,20);
        basket.add(milk,30);
        basket.add(apples,40);
        assertEquals("--------------------------------\n" +
                "soup              0.65 X    10    = 6.50\n" +
                "bread             0.80 X    20    = 16.00\n" +
                "milk              1.30 X    30    = 39.00\n" +
                "apples            0.10 X    40    = 4.00\n" +
                "--------------------------------\n" +
                "                  TOTAL:   65.50", basket.toString(LocalDate.parse("2020-11-01")));
    }
}