package designPatterns.orderingprocessingsystem;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMeal implements Meal {
    protected String size;
    protected List<String> ingredients;

    protected BaseMeal(String size, List<String> ingredients) {
        this.size = size;
        this.ingredients = new ArrayList<>(ingredients);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing meal: size=" + size + ", ingredients=" + ingredients);
    }

    @Override
    public abstract double getPrice();
}
