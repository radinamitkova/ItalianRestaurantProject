import exceptions.ProductOutOfStockException;
import exceptions.RestaurantFullException;
import models.*;

import java.util.*;

public class Main
{
  public static void main(String[] args) {
    int clients = 0;
    int restaurantRating = 0;
    Restaurant restaurant = new Restaurant(200);
    getEmployees(restaurant);
    Random random = new Random();
    Menu menu = new Menu();
    Kitchen kitchen = new Kitchen();

    restaurant.printEmployees();
    System.out.println(menu);

    try {
      clients = getNumberOfClients(restaurant, random);
    } catch (RestaurantFullException exception) {
      System.out.println(exception.getMessage());
      clients = restaurant.getSeats();
    }

    if (clients == 0) {
      System.out.println("There are no clients today");
      return;
    }

    Map<String, List> clientsOrders = new HashMap<>();
    for (int i = 1; i <= clients; i++) {
      Client client = new Client();
      System.out.println();
      System.out.println("-------");
      System.out.println("Client " + i);
      System.out.println("-------");
      int orderedDishes = 1 + random.nextInt(14);
      System.out.println("Ordered dishes : " + orderedDishes);
      for (int j = 0; j < orderedDishes; j++) {
        int dishNumber = random.nextInt(kitchen.getDishes().size());
        String nameOfOrderedDish = menu.getDishes().get(dishNumber).getName();
        System.out.println("- " + nameOfOrderedDish);
        try {
          kitchen.makeMeal(kitchen.getDishes().get(dishNumber));
          client.orderDish(menu.getDishes().get(dishNumber));
          restaurant.setOrderedDishes(nameOfOrderedDish, 1 + restaurant.getOrderedDishes().get(nameOfOrderedDish));
        } catch (ProductOutOfStockException exception) {
          System.out.println(exception.getMessage());
        }
      }
      client.payBill();
      if (client.getTipAmount() > 0) {
        System.out.printf("Client leave tip : %.2f lv.%n", client.getTipAmount());
      }
      System.out.printf("Client bill is : %.2f lv.%n", client.getBillTotal());
      int clientReview = getClientReview(random);
      restaurantRating += clientReview;
      restaurant.setClients(client);
    }

    restaurant.collectBills();
    restaurant.collectTips();
    restaurant.printEmployeeEarnings();
    restaurant.calculateTurnoverBeforeWages();

    System.out.printf("%nGenerated turnover for the day is : %.2f lv.", restaurant.getTurnover());
    System.out.printf("%nGenerated tips for the day are : %.2f lv.", restaurant.getTips());
    System.out.println();
    System.out.print("Restaurant rating is ");
    for (int i = 0; i < restaurantRating / restaurant.getClients().size(); i++) {
      System.out.print('\u2605' + " ");
    }
    System.out.println();
    System.out.println();

    for(Map.Entry<String, Integer> dish : restaurant.getOrderedDishes().entrySet()){
      if (dish.getValue().equals(1)) {
        System.out.println(dish.getKey() + " is ordered " + dish.getValue() + " time.");
      }
      else {
        System.out.println(dish.getKey() + " is ordered " + dish.getValue() + " times.");
      }
    }
    removeLeastOrderedItemFromMenu(restaurant, menu);


  }

  private static void removeLeastOrderedItemFromMenu(Restaurant restaurant, Menu menu){
    List<String> leastOrderedNames = new ArrayList<>();
    int leastOrdered = Integer.MAX_VALUE;
    int minValue = restaurant.getOrderedDishes().entrySet().stream().min(Map.Entry.comparingByValue()).get().getValue();

    for (Map.Entry<String, Integer> dish : restaurant.getOrderedDishes().entrySet()) {
      if (dish.getValue().equals(minValue)) {
        leastOrderedNames.add(dish.getKey());
      }
    }
    List<Meal> dishesByPrice = menu.getDishes();
    Collections.sort(dishesByPrice, (meal1, meal2) -> Double.compare(meal1.getPrice(), meal2.getPrice()));

    Meal mealToRemove = null;
    for (int i = 0; i < dishesByPrice.size(); i++) {
      for (int j = 0; j < leastOrderedNames.size(); j++) {
        if (dishesByPrice.get(i).getName().equalsIgnoreCase(leastOrderedNames.get(j))) {
          mealToRemove = dishesByPrice.get(i);
          menu.removeItemFromMenu(mealToRemove);
          System.out.printf("%nThe least ordered item from the menu is %s.%n", mealToRemove.getName());
          System.out.println();
          System.out.println(menu);
          return;
        }
      }
    }
  }

  private static int getClientReview(Random random)
  {
    int counter = 0;
    System.out.print("Client review ");
    for (int j = 0; j < random.nextInt(6) + 1; j++) {
      System.out.print('\u2605' + " ");
      counter++;
    }
    System.out.println();
    return counter;
  }

  private static int getNumberOfClients(Restaurant restaurant, Random random) throws RestaurantFullException
  {
    int clients = random.nextInt(restaurant.getSeats() + 1) + 10; // generate number of clients.
    System.out.println("Clients for the restaurant are " + clients);
    System.out.println();
    if (clients > restaurant.getSeats()) {
      throw new RestaurantFullException("Restaurant is full. " + (clients - restaurant.getSeats()) + " should wait for a table.");
    }
    return clients;
  }

  private static void getEmployees(Restaurant restaurant)
  {
    restaurant.addEmployee(new Employee("Ivan", "Ivanov", "Bartender", 50));
    restaurant.addEmployee(new Employee("Petar", "Georgiev", "Waiter", 30));
    restaurant.addEmployee(new Employee("Petya", "Ivanova", "Waiter", 30));
    restaurant.addEmployee(new Employee("Stefan", "Uzunov", "Waiter", 30));
    restaurant.addEmployee(new Employee("Georgi", "Asenov", "Manager", 90));
    restaurant.addEmployee(new Employee("Simeon", "Miladinov", "Chef", 80));
    restaurant.addEmployee(new Employee("Dimitar", "Stoikov", "Pizza maker", 60));
  }
}
