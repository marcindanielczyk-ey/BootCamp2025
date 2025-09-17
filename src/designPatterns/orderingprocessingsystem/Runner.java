package designPatterns.orderingprocessingsystem;

import designPatterns.orderingprocessingsystem.facade.OrderFacade;
import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        OrderFacade orderFacade = OrderFacade.getInstance();

        String mealType1 = "pizza";
        String size1 = "large";
        List<String> ingredients1 = Arrays.asList("cheese", "pepperoni");
        boolean extraCheese = true;
        PaymentStrategy payPal = amount -> System.out.println("Paying " + amount + "PLN with PayPal");

        orderFacade.placeOrder(mealType1, size1, ingredients1, extraCheese, payPal);

        System.out.println("---");

        String mealType2 = "burger";
        String size2 = "small";
        List<String> ingredients2 = Arrays.asList("lettuce", "tomato");
        String sauceType = "special";
        PaymentStrategy creditCard = amount -> System.out.println("Paying " + amount + "PLN with credit card");

        orderFacade.placeOrder(mealType2, size2, ingredients2, sauceType, creditCard);
    }
}
