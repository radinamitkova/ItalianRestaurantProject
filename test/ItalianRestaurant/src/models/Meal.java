package models;

import enumvalues.StartingProductAmount;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Meal {

    private String name;
    private String category;
    private int grams;
    private double price;
    private Map<StartingProductAmount, Integer> ingredients = new LinkedHashMap<>();

    public Meal(String name) {
        this.name = name;
    }

    public Meal(String name, String category, int grams, double price) {
        this.name = name;
        this.category = category;
        this.grams = grams;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getGrams() {
        return grams;
    }

    public double getPrice() {
        return price;
    }

    public Map<StartingProductAmount, Integer> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {

        return name + " - " + grams + "grams";

    }
}
