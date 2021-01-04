package org.iniad.se.sample12.sample1;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Item> items = new ArrayList<Item>();

    public Shop() {
    }

    public void register(Item item) {
        items.add(item);
    }

    public Item buy(Customer customer, String name) throws ShopException {
        Item matched = null;
        for(Item item : items) {
            if(item.getName().equals(name)) {
                matched = item;
                break;
            }
        }
        if(matched == null) {
            throw new ShopException("Not found");
        }

        Seller seller = matched.getSeller();
        int price = matched.getPrice();
        if(customer.getBalance() < price) {
            throw new ShopException("No money");
        }

        seller.transfer(price);
        customer.withdraw(price);

        items.remove(matched);
        return matched;
    }
}
