package edu.ntnu.idi.bidata;

/**
 * Class for initializing the class "UserUI". Starts the interaction and testing of the class
 * "Grocery".
 */
public class Application {

  /**
   * The method that is the start point for the application. Makes an instance of "UserUI", starts
   * the systems and tests.
   *
   * @param args Commandline arguments (not used).
   */
  public static void main(String[] args) {
    UserUI userUI = new UserUI();
    userUI.init();
    userUI.start();
  }
}
