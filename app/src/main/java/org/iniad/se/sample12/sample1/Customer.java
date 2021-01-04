package org.iniad.se.sample12.sample1;

public class Customer extends User {
    public Customer(String name) {
        super(name);
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public String getName() {
        return name;
    }
}