package designPatterns.orderingprocessingsystem.builder;

import designPatterns.orderingprocessingsystem.BaseMeal;
import java.util.ArrayList;
import java.util.List;

public class Pizza extends BaseMeal {
    private boolean extraCheese;

    private Pizza(PizzaBuilder builder) {
        super(builder.size, builder.ingredients);
        this.extraCheese = builder.extraCheese;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Pizza: size=" + size + ", ingredients=" + ingredients + ", extraCheese=" + extraCheese);
    }

    @Override
    public double getPrice() {
        double base = "small".equals(size) ? 10 : 15;
        return base + ingredients.size() + (extraCheese ? 2 : 0);
    }

    public static class PizzaBuilder {
        private String size;
        private List<String> ingredients = new ArrayList<>();
        private boolean extraCheese;

        public PizzaBuilder size(String size) {
            this.size = size;
            return this;
        }

        public PizzaBuilder ingredients(List<String> ingredients) {
            this.ingredients = new ArrayList<>(ingredients);
            return this;
        }

        public PizzaBuilder extraCheese(boolean extraCheese) {
            this.extraCheese = extraCheese;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
