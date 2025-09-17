package designPatterns.orderingprocessingsystem.strategy;

import designPatterns.orderingprocessingsystem.PaymentStrategy;

public class PayPal implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " PLN with PayPal");
    }
}
