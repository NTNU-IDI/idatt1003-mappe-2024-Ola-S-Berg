package edu.ntnu.idi.bidata;

import java.time.LocalDate;

/**
 * Klasse "UserUI" har ansvar for å teste Grocery klassen og håndtere brukergrensesnitt.
 */
public class UserUI {

  /**
   * Initialiserer systemet med å printe "Initializing system" for å indikere at systemet starter.
   */
  public void init() {
    System.out.println("Initializing system");
  }

  /**
   * Starter testingen av "Grocery" klassen ved å lage instanser av hver ingrediens, vise dem og
   * fange eventuelle feil i koden som ugyldig utløpsdato eller kvantitet.
   */
  public void start() {
    System.out.println("Testing class 'Grocery'");

    //Positive tester:
    try {
      Grocery milk = new Grocery("Milk", 1, "l", 20, LocalDate.of(2024, 11, 20));
      Grocery butter = new Grocery("Butter", 500, "g", 50, LocalDate.of(2024, 11, 30));

      System.out.println("Positive test cases:");
      System.out.println(milk);
      System.out.println(butter);

    } catch (Exception e) {
      System.out.println("Errors: " + e.getMessage());
    }

    //Negative tester:
    try {
      System.out.println("Negative test case:");
      Grocery eggs = new Grocery("Eggs", 6, "stk", 40, null);
      System.out.println(eggs);
      System.out.println("Error not caught");

    } catch (IllegalArgumentException e) {
      System.out.println("Error in expiryDate caught: " + e.getMessage());
    }

    try {
      System.out.println("Positive test case:");
      Grocery bacon = new Grocery("Bacon", -1, "stk", 80, LocalDate.of(2024, 11, 25));
      System.out.println(bacon);
      System.out.println("Error not caught");

    } catch (IllegalArgumentException e) {
      System.out.println("Error in quantity caught: " + e.getMessage());
    }
  }
}
