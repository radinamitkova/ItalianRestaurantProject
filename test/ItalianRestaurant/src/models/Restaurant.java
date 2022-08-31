package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant
{
  private final String               restaurantName = "Pasta la vista";
  private final int                  seats          = 30;
  private       double               currentAmount;
  private       Map<String, Integer> orderedDishes  = new HashMap<>();
  private       double               turnover;
  private       double               tips;
  private       List<Employee>       employees      = new ArrayList<>();
  private       List<Client>         clients        = new ArrayList<>();
  private       Menu                 menu           = new Menu();

  public Restaurant(double currentAmount)
  {
    this.currentAmount = currentAmount;
    for (int i = 0; i < menu.getDishes().size(); i++) {
      orderedDishes.put(menu.getDishes().get(i).getName(), 0);
    }
  }

  public void printEmployees()
  {
    System.out.printf("%36s%n%n%31s%n%n", this.restaurantName, "Staff");
    for (Employee employee : this.employees) {
      System.out.printf("%10s%-18s-%15s%n",
          " ", employee.getFirstName() + " " + employee.getLastName(), employee.getOccupation());
    }
    System.out.println();
  }

  public void addEmployee(Employee employee)
  {
    employees.add(employee);
  }

  public void collectBills()
  {
    for (Client client : clients) {
      this.turnover += client.getBillTotal();
    }
  }

  public void collectTips()
  {
    for (Client client : clients) {
      this.tips += client.getTipAmount();
    }
  }

  public String getRestaurantName()
  {
    return restaurantName;
  }

  public int getSeats()
  {
    return seats;
  }

  public double getCurrentAmount()
  {
    return currentAmount;
  }

  public void setCurrentAmount(double currentAmount)
  {
    this.currentAmount = currentAmount;
  }

  public Map<String, Integer> getOrderedDishes()
  {
    return orderedDishes;
  }

  public void setOrderedDishes(String name, Integer value)
  {
    this.orderedDishes.put(name, value);
  }

  public double getTurnover()
  {
    this.turnover = calculateTurnoverAfterWages();
    return turnover;
  }

  public double getTips()
  {
    return tips;
  }

  public void setTips(double tips)
  {
    this.tips = tips;
  }

  public List<Employee> getEmployees()
  {
    return employees;
  }

  public void setClients(Client client)
  {
    this.clients.add(client);
  }

  private double calculateTurnoverAfterWages()
  {
    return this.turnover - getWageCosts();
  }

  public double calculateTurnoverBeforeWages()
  {
    System.out.printf("%nTurnover before wages is: %.2f lv.%n", this.turnover);
    return this.turnover;
  }

  private double getWageCosts()
  {
    double totalWageCosts = 0;

    for (Employee employee : employees) {
      totalWageCosts += employee.getDailySalary();
    }
    System.out.printf("Total wage expenses: %.2f lv. %n", totalWageCosts);
    return totalWageCosts;
  }

  private double getIndividualTip()
  {
    int peopleReceivingTips = 0;

    for (Employee employee : this.employees) {
      if (employee.isTipable()) {
        peopleReceivingTips++;
      }
    }
    return this.tips / peopleReceivingTips;
  }

  public void printEmployeeEarnings()
  {
    double individualTipsForTheDay = getIndividualTip();

    System.out.printf("%n%20sEMPLOYEES EARNINGS%n", " ");
    for (Employee employee : this.employees) {
      if (employee.isTipable()) {
        System.out.printf("%-18s | %-12s | Salary: %-5.2f lv. Tips: %-5.2flv.%n",
            employee.getFirstName() + " " + employee.getLastName(), employee.getOccupation(), employee.getDailySalary(), individualTipsForTheDay);
      }
      else {
        System.out.printf("%-18s | %-12s | Salary: %-5.2f lv.%n",
            employee.getFirstName() + " " + employee.getLastName(), employee.getOccupation(), employee.getDailySalary());
      }
    }
  }

  public List<Client> getClients()
  {
    return clients;
  }
}
