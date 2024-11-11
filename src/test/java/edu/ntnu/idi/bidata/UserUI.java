package edu.ntnu.idi.bidata;

import java.sql.SQLOutput;
import java.time.LocalDate;

public class UserUI {

  public void init() {
    System.out.println("Initializing system");
  }

  public void start() {
    System.out.println("Testing class 'Grocery'");

    Grocery milk = new Grocery("Milk", 2, "Litre", 20, LocalDate.of(2024, 11, 20));
    Grocery butter = new Grocery("Butter", 3, "kg", 20, LocalDate.of(2024, 11, 30));
    Grocery eggs = new Grocery("Eggs", 4, "kg", 20, LocalDate.of(2024, 11, 25));

    System.out.println(milk);
    System.out.println(butter);
    System.out.println(eggs);
  }
}
