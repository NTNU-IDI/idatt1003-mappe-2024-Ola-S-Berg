package edu.ntnu.idi.bidata;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;

/**
 * Class "UserUI" has the responsibility of testing the "Grocery" class and handle user interface.
 */
public class UserUI {

  private Fridge fridge;
  private CookBook cookBook;
  private Scanner scanner;

  /**
   * Initializes the system while printing "Initializing system" to indicate that the system is
   * starting.
   */
  public void init() {
    System.out.println("Initializing system");
    this.fridge = new Fridge();
    this.cookBook = new CookBook();
    this.scanner = new Scanner(System.in);
  }


  /**
   * Starts the application by populating the fridge with sample groceries and sample recipes to
   * test the functionality of the classes.
   */
  public void start() {
    System.out.println("\nWelcome to the Grocery and Recipe System! Choose an option:");
    System.out.println("1. View all groceries currently in the fridge");
    System.out.println("2. Register a new grocery");
    System.out.println("3. View expired groceries");
    System.out.println("4. Remove a grocery");
    System.out.println("\n");
    System.out.println("5. View recipes in the cookbook");
    System.out.println("6. Add a new recipe");
    System.out.println("7. Find recipes possible to make with the groceries in your fridge");
    System.out.println("8. Exit");

    boolean running = true;
    while (running) {
      int choice = Integer.parseInt(scanner.nextLine());

      switch (choice) {
        case 1:
          viewAllGroceries();
          break;

        case 2:
          registerGrocery();
          break;

        case 3:
          removeGrocery();
          break;

        case 4:
          viewExpiredGroceries();
          break;

        case 5:
          viewRecipesInCookbook();

        case 6:
          addRecipe();
          break;

        case 7:
          possibleRecipes();
          break;

        case 8:
          System.out.println("Exiting the program.");
          running = false;
          break;
        default:
          System.out.println("Invalid option. Pick a valid option.");
      }
    }
  }

  /**
   * Method for viewing all groceries.
   */
  private void viewAllGroceries() {
    System.out.println(fridge);
  }

  /**
   * Method for registering a new grocery based on user input.
   */
  private void registerGrocery() {
    System.out.print("Enter grocery name: ");
    String name = scanner.nextLine();
    System.out.print("Enter quantity: ");
    double quantity = Double.parseDouble(scanner.nextLine());
    System.out.println("Enter unit (ml, g, pcs): ");
    String unit = scanner.nextLine();
    System.out.println("Enter price: ");
    double price = Double.parseDouble(scanner.nextLine());
    System.out.println("Enter expiry date (yyyy-mm-dd): ");
    LocalDate expiryDate = LocalDate.parse(scanner.nextLine());

    Grocery grocery = new Grocery(name, quantity, unit, price, expiryDate);
    fridge.registerGrocery(grocery);
    System.out.println("Grocery added successfully!");
  }

  private void removeGrocery() {
    System.out.print("Enter grocery name: ");
    String name = scanner.nextLine();
    System.out.println("Enter quantity: ");
    double quantity = Double.parseDouble(scanner.nextLine());
    try {
      fridge.removeGrocery(name, quantity);
      System.out.println("Grocery removed successfully!");
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private void viewExpiredGroceries() {
    System.out.println("Enter the date to check expired groceries (yyyy-mm-dd): ");
    LocalDate date = LocalDate.parse(scanner.nextLine());
    List<Grocery> expiredGroceries = fridge.getExpiredGroceries(date);
    if (expiredGroceries.isEmpty()) {
      System.out.println("No expired groceries found.");
    } else {
      expiredGroceries.forEach(g -> System.out.println(g));
    }
  }

  private void viewRecipesInCookbook() {
    System.out.println(cookBook);
  }

  private void addRecipe() {
    System.out.print("Enter recipe name: ");
    String name = scanner.nextLine();
    System.out.print("Enter recipe description: ");
    String description = scanner.nextLine();
    System.out.print("Enter recipe procedure: ");
    String procedure = scanner.nextLine();
    System.out.println("Enter recipe time (minutes): ");
    int time = Integer.parseInt(scanner.nextLine());
    System.out.println("Enter recipe servings: ");
    int servings = Integer.parseInt(scanner.nextLine());

    Nutrients nutrients = new Nutrients(250, 10, 5, 35);
    Recipe recipe = new Recipe(name, description, procedure, time, servings, nutrients);
    cookBook.addRecipe(recipe);
    System.out.println("Recipe added successfully!");
  }

  private void possibleRecipes() {
    System.out.println("Finding recipes based on your fridge...");
    List<Recipe> recipes = cookBook.findAllPossibleRecipes(fridge);
    recipes.forEach(recipe -> System.out.println(recipe));
  }
}
/**
 * fridge.registerGrocery(new Grocery("Milk", 500, "ml", 20, LocalDate.of(2024, 12, 20)));
 * fridge.registerGrocery(new Grocery("Flour", 300, "g", 5, LocalDate.of(2024, 12, 23)));
 * fridge.registerGrocery(new Grocery("Butter", 500, "g", 50, LocalDate.of(2024, 12, 30)));
 * fridge.registerGrocery(new Grocery("Eggs", 6, "pcs", 40, LocalDate.of(2024, 12, 22)));
 * fridge.registerGrocery(new Grocery("Bacon", 5, "pcs", 80, LocalDate.of(2024, 12, 25)));
 * <p>
 * System.out.println(fridge);
 * <p>
 * Nutrients pancakeNutrients = new Nutrients(350, 12, 10, 50); Recipe pancakes = new
 * Recipe("Pancakes", "Fluffy pancakes", "Mix and fry", 10, 4, pancakeNutrients);
 * pancakes.addIngredient(new Grocery("Milk", 300, "ml", 20, LocalDate.of(2024, 12, 20)));
 * pancakes.addIngredient(new Grocery("Flour", 200, "g", 5, LocalDate.of(2024, 12, 23)));
 * <p>
 * Nutrients waffleNutrients = new Nutrients(500, 16, 15, 53); Recipe waffles = new
 * Recipe("Waffles", "Crispy waffles", "Mix and cook", 15, 4, waffleNutrients);
 * waffles.addIngredient(new Grocery("Milk", 200, "ml", 20, LocalDate.of(2024, 12, 20)));
 * waffles.addIngredient(new Grocery("Flour", 100, "g", 5, LocalDate.of(2024, 12, 23)));
 * <p>
 * cookBook.addRecipe(pancakes); cookBook.addRecipe(waffles);
 * <p>
 * System.out.println("\nCookbook contents:"); System.out.println(cookBook);
 * <p>
 * List<Recipe> possibleRecipes = cookBook.findAllPossibleRecipes(fridge);
 * System.out.println("\nRecipes you can make with your current fridge contents:"); if
 * (possibleRecipes.isEmpty()) { System.out.println("\nNo recipes can be made with the available
 * ingredients"); } else { for (Recipe recipe : possibleRecipes) {
 * System.out.println(recipe.getName()); } } } }
 */
