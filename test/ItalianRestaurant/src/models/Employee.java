package models;

public class Employee
{
  private String firstName;
  private String lastName;
  private double dailySalary;
  private String occupation;

  public Employee()
  {
  }

  public Employee(String firstName, String lastName, String occupation, double dailySalary)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.occupation = occupation;
    this.dailySalary = dailySalary;
    isTipable();
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public double getDailySalary()
  {
    return dailySalary;
  }

  public String getOccupation()
  {
    return occupation;
  }

  public boolean isTipable()
  {
    if (this.occupation.equalsIgnoreCase("waiter") ||
        this.occupation.equalsIgnoreCase("bartender")) {
      return true;
    }
    return false;
  }
}
