package designPatterns.orderingprocessingsystem.strategy;

import designPatterns.orderingprocessingsystem.PaymentStrategy;

public class CreditCard implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " PLN with credit card");
    }
}
