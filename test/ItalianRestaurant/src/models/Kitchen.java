package models;

import enumvalues.StartingProductAmount;
import exceptions.ProductOutOfStockException;

import static enumvalues.StartingProductAmount.*;

import java.util.*;


public class Kitchen
{

  private Map<StartingProductAmount, Integer> productAmount;
  private List<Meal>                          dishes;

  public Kitchen()
  {
    this.dishes = new ArrayList<>();
    this.productAmount = new HashMap<>();
    getStartingAmount();
    generateMeals();
  }

  private void generateMeals()
  {
    Meal mealToAdd = new Meal("Pizza Margherita");
    dishes.add(mealToAdd);
    mealToAdd.getIngredients().put(TOMATO_SAUCE, 50);
    mealToAdd.getIngredients().put(DOUGH, 250);
    mealToAdd.getIngredients().put(TOMATO, 40);
    mealToAdd.getIngredients().put(MOZZARELLA, 60);
    mealToAdd.getIngredients().put(BASIL, 10);

    mealToAdd = new Meal("Pizza Italy");
    dishes.add(mealToAdd);
    mealToAdd.getIngredients().put(TOMATO_SAUCE, 50);
    mealToAdd.getIngredients().put(DOUGH, 200);
    mealToAdd.getIngredients().put(MUSHROOMS, 60);
    mealToAdd.getIngredients().put(MOZZARELLA, 100);
    mealToAdd.getIngredients().put(BASIL, 10);
    mealToAdd.getIngredients().put(PROSCIUTTO, 80);
    mealToAdd.getIngredients().put(OLIVES, 60);
    mealToAdd.getIngredients().put(ONION, 40);

    mealToAdd = new Meal("Quattro Stagioni Pizza");
    dishes.add(mealToAdd);
    mealToAdd.getIngredients().put(TOMATO_SAUCE, 50);
    mealToAdd.getIngredients().put(DOUGH, 210);
    mealToAdd.getIngredients().put(CORN, 40);
    mealToAdd.getIngredients().put(MOZZARELLA, 60);
    mealToAdd.getIngredients().put(TOMATO, 20);
    mealToAdd.getIngredients().put(CHICKEN_FILLET, 100);
    mealToAdd.getIngredients().put(BACON, 80);
    mealToAdd.getIngredients().put(MUSHROOMS, 40);

    mealToAdd = new Meal("Tagliatelle Carbonara");
    dishes.add(mealToAdd);
    mealToAdd.getIngredients().put(TAGLIATELLE, 140);
    mealToAdd.getIngredients().put(BACON, 90);
    mealToAdd.getIngredients().put(PARMESAN, 50);
    mealToAdd.getIngredients().put(EGG, 30);
    mealToAdd.getIngredients().put(MUSHROOMS, 80);
    mealToAdd.getIngredients().put(COOKING_CREAM, 60);

    mealToAdd = new Meal("Spaghetti Bolognese");
    dishes.add(mealToAdd);
    mealToAdd.getIngredients().put(TOMATO_SAUCE, 60);
    mealToAdd.getIngredients().put(SPAGHETTI, 140);
    mealToAdd.getIngredients().put(MINCED_MEAT, 100);
    mealToAdd.getIngredients().put(PARMESAN, 60);
    mealToAdd.getIngredients().put(BASIL, 10);
    mealToAdd.getIngredients().put(ONION, 30);
    mealToAdd.getIngredients().put(CARROTS, 50);

    mealToAdd = new Meal("Chicken And Broccoli Tagliatelle");
    dishes.add(mealToAdd);
    mealToAdd.getIngredients().put(TAGLIATELLE, 140);
    mealToAdd.getIngredients().put(CHICKEN_FILLET, 100);
    mealToAdd.getIngredients().put(PARMESAN, 50);
    mealToAdd.getIngredients().put(BROCCOLI, 60);
    mealToAdd.getIngredients().put(COOKING_CREAM, 50);

    mealToAdd = new Meal("Lasagna");
    dishes.add(mealToAdd);
    mealToAdd.getIngredients().put(TOMATO_SAUCE, 60);
    mealToAdd.getIngredients().put(LASAGNA_CRUSTS, 90);
    mealToAdd.getIngredients().put(MINCED_MEAT, 100);
    mealToAdd.getIngredients().put(PARMESAN, 80);
    mealToAdd.getIngredients().put(BASIL, 10);
    mealToAdd.getIngredients().put(ONION, 30);
    mealToAdd.getIngredients().put(CARROTS, 30);

    mealToAdd = new Meal("Chicken And Mushroom Risotto");
    dishes.add(mealToAdd);
    mealToAdd.getIngredients().put(RICE, 120);
    mealToAdd.getIngredients().put(CHICKEN_FILLET, 100);
    mealToAdd.getIngredients().put(PARMESAN, 30);
    mealToAdd.getIngredients().put(MUSHROOMS, 40);
    mealToAdd.getIngredients().put(COOKING_CREAM, 50);
    mealToAdd.getIngredients().put(ONION, 10);
    mealToAdd.getIngredients().put(SAUVIGNON_BLANC_WINE, 20);

    mealToAdd = new Meal("Vegetable Risotto");
    dishes.add(mealToAdd);
    mealToAdd.getIngredients().put(RICE, 160);
    mealToAdd.getIngredients().put(TOMATO, 40);
    mealToAdd.getIngredients().put(PARMESAN, 40);
    mealToAdd.getIngredients().put(CORN, 30);
    mealToAdd.getIngredients().put(ONION, 20);
    mealToAdd.getIngredients().put(CARROTS, 40);
    mealToAdd.getIngredients().put(MUSHROOMS, 50);
    mealToAdd.getIngredients().put(SAUVIGNON_BLANC_WINE, 20);

    mealToAdd = new Meal("Water");
    dishes.add(mealToAdd);
    mealToAdd.getIngredients().put(WATER, 500);

    mealToAdd = new Meal("Soda");
    dishes.add(mealToAdd);
    mealToAdd.getIngredients().put(SODA, 500);

    mealToAdd = new Meal("Sauvignon Blanc Wine");
    dishes.add(mealToAdd);
    mealToAdd.getIngredients().put(SAUVIGNON_BLANC_WINE, 250);

    mealToAdd = new Meal("Chardonnay Wine");
    dishes.add(mealToAdd);
    mealToAdd.getIngredients().put(CHARDONNAY_WINE, 250);

    mealToAdd = new Meal("Rose Wine");
    dishes.add(mealToAdd);
    mealToAdd.getIngredients().put(ROSE_WINE, 250);
  }

  public List<Meal> getDishes()
  {
    return dishes;
  }

  public void printProducts()
  {
    for (Map.Entry<StartingProductAmount, Integer> ingredient : productAmount.entrySet()) {
      System.out.println(ingredient.getKey() + " " + ingredient.getValue());
    }
  }

  public void getStartingAmount()
  {
    StartingProductAmount[] startingProducts = StartingProductAmount.values();
    for (StartingProductAmount startingProduct : startingProducts) {
      this.productAmount.put(startingProduct, startingProduct.getGrams());
    }
  }

  public void makeMeal(Meal meal) throws ProductOutOfStockException
  {
    for (Map.Entry<StartingProductAmount, Integer> ingredient : meal.getIngredients().entrySet()) {
      int ingredientLeft = this.productAmount.get(ingredient.getKey()) - ingredient.getValue();
      if (ingredientLeft < 0) {
        throw new ProductOutOfStockException
            ("Can't make " + meal.getName() + ". Not enough " + ingredient.getKey().getName().toLowerCase() + "\n");
      }
      this.productAmount.put(ingredient.getKey(), ingredientLeft);
    }
    System.out.println("/Served " + meal.getName());
    System.out.println();
  }
}
