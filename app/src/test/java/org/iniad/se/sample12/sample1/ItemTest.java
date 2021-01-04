package org.iniad.se.sample12.sample1;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;


public class ItemTest {
    private Item item;
    private Seller seller;

    @Before
    public void setUp() {
        seller = new Seller("Tanaka", "Tocho");
        item = new Item(seller, "Ramen", 400);
    }

    @Test
    public void getSeller() {
        assertThat(item.getSeller(), is(seller));
    }

    @Test
    public void getName() {
        assertThat(item.getName(), is("Ramen"));
    }

    @Test
    public void getPrice() {
        assertThat(item.getPrice(), is(400));
    }
}