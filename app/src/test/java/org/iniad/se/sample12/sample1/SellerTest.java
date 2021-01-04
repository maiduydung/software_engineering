package org.iniad.se.sample12.sample1;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;


public class SellerTest {
    private Seller seller;

    @Before
    public void setUp() {
        seller = new Seller("Tanaka", "Tocho");
    }

    @Test
    public void testTransfer() {
        seller.transfer(100);
        assertThat(seller.getBalance(), is(100));
    }

    @Test
    public void testGetName() {
        assertThat(seller.getName(), is("Tocho(Tanaka)"));
    }
}