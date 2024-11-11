package edu.ntnu.idi.bidata;

//Klasse for å kjøre "UserUI" klassen.
public class Application {

  public static void main(String[] args) {
    UserUI userUI = new UserUI();
    userUI.init();
    userUI.start();
  }
}
