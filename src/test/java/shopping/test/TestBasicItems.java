package shopping.test;

import org.junit.Before;
import org.junit.Test;
import shopping.core.Product;
import shopping.core.Basket;
import shopping.core.Item;

import static org.junit.Assert.assertEquals;

public class TestBasicItems {

    private Basket basket;
    private Item item;

    @Before
    public void setUp() {
        basket = new Basket();
        item = new Product("soup", 10);
    }

    @Test
    public void test_emptyCartCostsZero() {
        assertEquals(0,basket.total(),basket.total());
    }

    @Test
    public void test_singleBasicItemCostsItsUnitPrice() {
        basket.add(item);
        assertEquals(item.unitPrice(), basket.total(),basket.total());
    }

    @Test
    public void test_multipleBasicItemsCostProportionally() {
        int howMany = 3;
        basket.add(item, howMany);
        assertEquals(howMany * item.unitPrice(), basket.total(),basket.total());
    }

    @Test
    public void test_separatelyAdding() {
        int howMany = 3;
        for (int i = howMany; i > 0; i--) {
            basket.add(item);
        }
        assertEquals(howMany * item.unitPrice(), basket.total(),basket.total());
    }
}