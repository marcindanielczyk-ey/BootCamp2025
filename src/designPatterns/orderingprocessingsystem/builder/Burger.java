package designPatterns.orderingprocessingsystem.builder;

import designPatterns.orderingprocessingsystem.Meal;

import java.util.ArrayList;
import java.util.List;

public class Burger implements Meal {
    private String size;
    private List<String> ingredients;
    private String sauceType;

    private Burger(BurgerBuilder builder) {
        this.size = builder.size;
        this.ingredients = builder.ingredients;
        this.sauceType = builder.sauceType;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Burger: size=" + size + ", ingredients=" + ingredients + ", sauceType=" + sauceType);
    }

    @Override
    public double getPrice() {
        double base = "small".equals(size) ? 8 : 12;
        return base + ingredients.size() + ("special".equals(sauceType) ? 1 : 0);
    }

    public static class BurgerBuilder {
        private String size;
        private List<String> ingredients = new ArrayList<>();
        private String sauceType;

        public BurgerBuilder size(String size) { this.size = size; return this; }
        public BurgerBuilder ingredients(List<String> ingredients) { this.ingredients = ingredients; return this; }
        public BurgerBuilder sauceType(String sauceType) { this.sauceType = sauceType; return this; }
        public Burger build() { return new Burger(this); }
    }
}
