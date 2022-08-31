package models;

import java.util.LinkedList;
import java.util.List;


public class Menu {

    private List<Meal> dishes = new LinkedList<>();

    public Menu() {
        makeMenu();
    }

    public Menu(List<Meal> dishes) {
        this.dishes = dishes;
    }

    public void makeMenu() {
        dishes.add(new Meal("Pizza Margherita", "Pizza", 400, 5.90));
        dishes.add(new Meal("Pizza Italy", "Pizza", 600, 8.40));
        dishes.add(new Meal("Quattro Stagioni Pizza", "Pizza", 600, 8.80));

        dishes.add(new Meal("Tagliatelle Carbonara", "Pasta", 450, 7.40));
        dishes.add(new Meal("Spaghetti Bolognese", "Pasta", 450, 6.90));
        dishes.add(new Meal("Chicken and Broccoli Tagliatelle", "Pasta", 400, 8.20));
        dishes.add(new Meal("Lasagna", "Pasta", 400, 8.50));

        dishes.add(new Meal("Chicken and Mushroom Risotto", "Risotto", 370, 8.20));
        dishes.add(new Meal("Vegetable Risotto", "Risotto", 400, 7.80));

        dishes.add(new Meal("Water", "Drink", 500, 1.20));
        dishes.add(new Meal("Soda", "Drink", 500, 1.70));
        dishes.add(new Meal("Sauvignon Blanc Wine", "Drink", 250, 2.80));
        dishes.add(new Meal("Chardonnay Wine", "Drink", 250, 3.00));
        dishes.add(new Meal("Rosé Wine", "Drink", 250, 3.40));
    }

    public void removeItemFromMenu(Meal meal){
        this.dishes.remove(meal);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        System.out.printf("%30s%n%n","MENU");
        for (Meal dish : this.dishes) {
           String price = String.format("%.2f", dish.getPrice());
           if(dish.getCategory().equals("Drink")) {
               sb.append(String.format("%-32s",dish.getName())).append(" /").append(dish.getGrams()).append(" ml/ ........ ").append(price)
                       .append(" lv.\n");
           }
           else {
               sb.append(String.format("%-32s",dish.getName())).append(" /").append(dish.getGrams()).append(" g / ........ ").append(price)
                       .append(" lv.\n");
           }
        }
        return sb.toString();
    }

    public List<Meal> getDishes()
    {
        return new LinkedList<>(dishes);
    }
}