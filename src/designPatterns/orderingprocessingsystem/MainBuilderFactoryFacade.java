package designPatterns.orderingprocessingsystem;

import designPatterns.orderingprocessingsystem.builder.Burger;
import designPatterns.orderingprocessingsystem.builder.Pizza;
import designPatterns.orderingprocessingsystem.facade.OrderFacade;
import designPatterns.orderingprocessingsystem.factory.MealFactory;
import designPatterns.orderingprocessingsystem.strategy.CreditCard;
import designPatterns.orderingprocessingsystem.strategy.PayPal;

import java.util.Arrays;

public class MainBuilderFactoryFacade {
    public static void main(String[] args) {
        // Builder
        Meal pizzaBuilder = new Pizza.PizzaBuilder()
                .size("large")
                .ingredients(Arrays.asList("cheese", "pepperoni", "mushrooms"))
                .extraCheese(true)
                .build();
        pizzaBuilder.prepare();
        System.out.println("Pizza price: $" + pizzaBuilder.getPrice());

        Meal burgerBuilder = new Burger.BurgerBuilder()
                .size("small")
                .ingredients(Arrays.asList("lettuce", "tomato"))
                .sauceType("special")
                .build();
        burgerBuilder.prepare();
        System.out.println("Burger price: $" + burgerBuilder.getPrice());

        // Factory
        Meal pizzaFactory = MealFactory.createMeal("pizza", "large", Arrays.asList("cheese", "pepperoni"), true);
        pizzaFactory.prepare();
        System.out.println("Pizza price: $" + pizzaFactory.getPrice());

        Meal burgerFactory = MealFactory.createMeal("burger", "small", Arrays.asList("lettuce", "tomato"), "special");
        burgerFactory.prepare();
        System.out.println("Burger price: $" + burgerFactory.getPrice());

        // Facade
        OrderFacade orderFacade = OrderFacade.getInstance();

        PaymentStrategy payPal = new PayPal();
        orderFacade.placeOrder(
                "pizza",
                "large",
                Arrays.asList("cheese", "pepperoni"),
                true,
                payPal
        );

        PaymentStrategy creditCard = new CreditCard();
        orderFacade.placeOrder(
                "burger",
                "small",
                Arrays.asList("lettuce", "tomato"),
                "special",
                creditCard
        );
    }
}
