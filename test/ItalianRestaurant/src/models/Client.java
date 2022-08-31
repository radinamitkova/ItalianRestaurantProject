package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client
{
  private static final int        MIN_TIP       = 5;
  private static final int        MAX_TIP       = 15;
  private              List<Meal> orderedDishes = new ArrayList<>();
  private              double     billTotal;
  private              double     tipAmount;


  public double getBillTotal()
  {
    return billTotal;
  }

  public double getTipAmount()
  {
    return tipAmount;
  }

  public List<Meal> getOrderedDishes()
  {
    return orderedDishes;
  }

  private void getBill()
  {
    for (Meal meal : orderedDishes) {
      this.billTotal += meal.getPrice();
    }
  }

  public void orderDish(Meal meal)
  {
    this.orderedDishes.add(meal);
  }

  public void payBill()
  {
    getBill();
    leaveTip();
  }

  public void leaveTip()
  {
    Random random = new Random();
    boolean leaveTip = random.nextBoolean();
    if (leaveTip) {
      int percentage = random.nextInt((MAX_TIP - MIN_TIP) + 1) + MIN_TIP;
      this.tipAmount = Math.round((this.billTotal * percentage) / 100);
    }
    else {
      System.out.println("Client didn't leave a tip");
    }
  }
}

