package edu.ntnu.idi.bidata;

/**
 * Klasse for å initialisere klassen "UserUI". Starter interaksjonen og testingen av klassen
 * "Grocery".
 */
public class Application {

  /**
   * Metoden som er startpunktet til applikasjonen. Lager en instanse av "UserUI", starter systemer
   * og starter testene.
   *
   * @param args Kommandolinje argumenter (ikke brukt).
   */
  public static void main(String[] args) {
    UserUI userUI = new UserUI();
    userUI.init();
    userUI.start();
  }
}
