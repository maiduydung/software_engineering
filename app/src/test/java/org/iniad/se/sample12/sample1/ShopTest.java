package org.iniad.se.sample12.sample1;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;


public class ShopTest {
    private Shop shop;
    private Seller seller;
    private Customer customer;
    private Item item;

//    @Before
//    public void init() {
//        shop = new Shop();
//        seller = new Seller("Tanaka", "Tocho");
//        customer = new Customer("Taro");
//        item = new Item(seller, "Ramen", 400);
//        shop.register(item);
//    }
    @Before
    public void init() {
        shop = new Shop();
        seller = mock(Seller.class);
        customer = mock((Customer.class));
        item = mock(Item.class);
        shop.register(item);
    }


    @Test
    public void testBuy1() throws ShopException {
        when(item.getName()).thenReturn("Ramen");
        when(item.getSeller()).thenReturn(seller);
        when(item.getPrice()).thenReturn(400);
        when(customer.getBalance()).thenReturn(500);
        Item bought = shop.buy(customer,"Ramen");
        assertThat(bought, is(item));
        verify(seller).transfer(400);
        verify(customer).withdraw(400);
    }

    @Test(expected = ShopException.class)
    public void testBuy2() throws ShopException {
        when(item.getName()).thenReturn("Ramen");
        when(item.getSeller()).thenReturn(seller);
        when(item.getPrice()).thenReturn(400);
        when(customer.getBalance()).thenReturn(0);
        customer.charge(300);
        Item bought = shop.buy(customer, "Ramen");
        when(bought).thenThrow(new ShopException("not enough cash"));
    }
//
//    @Test(expected = ShopException.class)
//    public void testBuy2() throws ShopException {
//        customer.charge(300);
//        Item bought = shop.buy(customer, "Ramen");
//    }
//

//    @Test(expected = ShopException.class)
//    public void testBuy3() throws ShopException {
//        customer.charge(500);
//        Item bought = shop.buy(customer, "Noodle");
//    }

    @Test(expected = ShopException.class)
    public void testBuy3() throws ShopException {
        when(item.getName()).thenReturn("Ramen");
        when(item.getSeller()).thenReturn(seller);
        when(item.getPrice()).thenReturn(400);
        when(customer.getBalance()).thenReturn(0);
        customer.charge(500);
        Item bought = shop.buy(customer, "Noodle");
        when(bought).thenThrow(new ShopException("given too much"));
    }

}