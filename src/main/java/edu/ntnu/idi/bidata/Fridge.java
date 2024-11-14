package edu.ntnu.idi.bidata;

import java.util.ArrayList;

public class Fridge {

  private ArrayList<Grocery> groceries;

  public Fridge() {
    groceries = new ArrayList<>();
  }

  public void registerGrocery(Grocery grocery) {
    groceries.add(grocery);
  }
}
