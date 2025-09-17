package designPatterns.orderingprocessingsystem.factory;

import designPatterns.orderingprocessingsystem.builder.Burger;
import designPatterns.orderingprocessingsystem.Meal;
import designPatterns.orderingprocessingsystem.builder.Pizza;

import java.util.List;

public class MealFactory {
    private static final MealFactory INSTANCE = new MealFactory();

    private MealFactory() {
    }

    public static MealFactory getInstance() {
        return INSTANCE;
    }

    public static Meal createMeal(String mealType, String size, List<String> ingredients, Object specificOption) {
        if ("pizza".equalsIgnoreCase(mealType)) {
            return new Pizza.PizzaBuilder()
                    .size(size)
                    .ingredients(ingredients)
                    .extraCheese((Boolean) specificOption)
                    .build();
        } else if ("burger".equalsIgnoreCase(mealType)) {
            return new Burger.BurgerBuilder()
                    .size(size)
                    .ingredients(ingredients)
                    .sauceType((String) specificOption)
                    .build();
        }
        throw new IllegalArgumentException("Invalid meal type: " + mealType);
    }
}