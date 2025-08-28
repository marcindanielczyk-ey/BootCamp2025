package designPatterns.orderingprocessingsystem.facade;

import designPatterns.orderingprocessingsystem.Meal;
import designPatterns.orderingprocessingsystem.PaymentStrategy;
import designPatterns.orderingprocessingsystem.factory.MealFactory;

import java.util.List;

public class OrderFacade {
    private static final OrderFacade INSTANCE = new OrderFacade();

    private OrderFacade() {}

    public static OrderFacade getInstance() {
        return INSTANCE;
    }

    public void placeOrder(String mealType, String size, List<String> ingredients, Object specificOption, PaymentStrategy paymentStrategy) {
        Meal meal = MealFactory.getInstance().createMeal(mealType, size, ingredients, specificOption);
        meal.prepare();

        double price = meal.getPrice();
        paymentStrategy.pay(price);
    }
}
