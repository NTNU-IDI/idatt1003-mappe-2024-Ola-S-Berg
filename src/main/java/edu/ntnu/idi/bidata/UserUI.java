package edu.ntnu.idi.bidata;

import java.util.Map;
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
   * starting. Creates a new fridge and a new cookbook with their sample contents.
   */
  public void init() {
    System.out.println("Initializing system");
    this.fridge = new Fridge();
    this.cookBook = new CookBook();
    this.scanner = new Scanner(System.in);

    fridge.registerGrocery(new Grocery("Milk", 1000, "ml", 40, LocalDate.of(2024, 12, 15)));
    fridge.registerGrocery(new Grocery("Butter", 500, "g", 50, LocalDate.of(2024, 12, 30)));
    fridge.registerGrocery(new Grocery("Eggs", 6, "pcs", 20, LocalDate.of(2024, 12, 22)));
    fridge.registerGrocery(new Grocery("Bacon", 5, "pcs", 80, LocalDate.of(2024, 12, 25)));
    fridge.registerGrocery(new Grocery("Flour", 500, "g", 50, LocalDate.of(2024, 12, 30)));
    fridge.registerGrocery(new Grocery("Ground beef", 800, "g", 200, LocalDate.of(2024, 12, 25)));
    fridge.registerGrocery(new Grocery("Cheese", 500, "g", 120, LocalDate.of(2024, 12, 18)));
    fridge.registerGrocery(new Grocery("Tortillas", 8, "pcs", 40, LocalDate.of(2024, 12, 30)));
    fridge.registerGrocery(new Grocery("Cabbage", 2, "pcs", 80, LocalDate.of(2024, 12, 14)));

    Nutrients pancakeNutrients = new Nutrients(350, 12, 10, 50);
    Recipe pancakes = new Recipe("Pancakes", "Fluffy pancakes", "Mix and fry", 10, 4,
        pancakeNutrients);
    pancakes.addIngredient(new Grocery("Milk", 300, "ml", 20, LocalDate.of(2024, 12, 20)));
    pancakes.addIngredient(new Grocery("Flour", 200, "g", 5, LocalDate.of(2024, 12, 23)));

    Nutrients waffleNutrients = new Nutrients(500, 16, 15, 53);
    Recipe waffles = new Recipe("Waffles", "Crispy waffles", "Mix and cook", 15, 4,
        waffleNutrients);
    waffles.addIngredient(new Grocery("Milk", 200, "ml", 20, LocalDate.of(2024, 12, 20)));
    waffles.addIngredient(new Grocery("Flour", 100, "g", 5, LocalDate.of(2024, 12, 23)));

    Nutrients tacoNutrients = new Nutrients(400, 20, 15, 30);
    Recipe tacos = new Recipe("Tacos", "Dinner tacos", "Prepare ingredients and cook ground beef",
        15, 2, tacoNutrients);
    tacos.addIngredient(new Grocery("Ground beef", 400, "g", 100, LocalDate.of(2024, 12, 25)));
    tacos.addIngredient(new Grocery("Tortillas", 8, "pcs", 40, LocalDate.of(2024, 12, 30)));
    tacos.addIngredient(new Grocery("Cabbage", 1, "pcs", 40, LocalDate.of(2024, 12, 14)));
    tacos.addIngredient(new Grocery("Cheese", 100, "g", 30, LocalDate.of(2024, 12, 18)));

    Nutrients baconAndEggsNutrients = new Nutrients(200, 30, 50, 5);
    Recipe baconAndEggs = new Recipe("Bacon and Eggs", "Breakfast Bacon and Eggs", "Fry in a pan",
        15, 2, baconAndEggsNutrients);
    baconAndEggs.addIngredient(new Grocery("Eggs", 6, "pcs", 20, LocalDate.of(2024, 12, 22)));
    baconAndEggs.addIngredient(new Grocery("Bacon", 10, "pcs", 160, LocalDate.of(2024, 12, 30)));

    cookBook.addRecipe(pancakes);
    cookBook.addRecipe(waffles);
    cookBook.addRecipe(tacos);
    cookBook.addRecipe(baconAndEggs);
  }

  /**
   * Starts the application by populating the fridge with sample groceries and sample recipes to
   * test the functionality of the classes.
   */
  public void start() {
    System.out.println("\nWelcome to the Grocery and Recipe System! Choose an option:");
    System.out.println("1. View fridge contents");
    System.out.println("2. Register a new grocery to the fridge");
    System.out.println("3. Remove a grocery from the fridge");
    System.out.println("4. View expired groceries");
    System.out.println("5. View recipes in the cookbook");
    System.out.println("6. Add a new recipe");
    System.out.println("7. Find recipes possible to make with the groceries in your fridge");
    System.out.println("8. Generate shopping list for a recipe");
    System.out.println("9. Get suggested meals by nutrients");
    System.out.println("10. Get suggested meals by expiration date");
    System.out.println("11. Exit");

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
          break;

        case 6:
          addRecipe();
          break;

        case 7:
          possibleRecipes();
          break;

        case 8:
          generateShoppingList();
          break;

        case 9:
          suggestRecipesByMacronutrient();
          break;

        case 10:
          suggestRecipesByExpiryDate();
          break;

        case 11:
          System.out.println("Exiting the program.");
          running = false;
          break;

        default:
          System.out.println("Invalid option. Please pick a valid option.");
      }
    }
  }

  /**
   * Method for viewing all groceries and finding the total sum of their price.
   */
  private void viewAllGroceries() {
    System.out.println(fridge);
    fridge.getTotalSumPrice();
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

  /**
   * Method for removing a quantity of a grocery from the fridge.
   */
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

  /**
   * Method for printing all the expired groceries in the fridge. Also gets the total sum of the
   * price of all expired groceries in the fridge.
   */
  private void viewExpiredGroceries() {
    System.out.println("Enter the date to check expired groceries (yyyy-mm-dd): ");
    LocalDate date = LocalDate.parse(scanner.nextLine());
    List<Grocery> expiredGroceries = fridge.getExpiredGroceries(date);

    double totalExpiredPrice = 0.0;
    for (Grocery grocery : expiredGroceries) {
      totalExpiredPrice += grocery.getPrice();
    }

    if (expiredGroceries.isEmpty()) {
      System.out.println("No expired groceries found.");
    } else {
      expiredGroceries.forEach(System.out::println);
    }
    System.out.println("Total price of expired groceries: " + totalExpiredPrice + "kr");
  }

  /**
   * Method for printing all recipes in the cookbook.
   */
  private void viewRecipesInCookbook() {
    System.out.println(cookBook);
  }

  /**
   * Method for adding a new recipe to the cookbook.
   */
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
    addIngredientsToRecipe(recipe);
    cookBook.addRecipe(recipe);
    System.out.println("Recipe added successfully!");
  }

  /**
   * Helper method for method "addRecipe". Prompts the user to add ingredients to the new recipe.
   *
   * @param recipe The recipe to add ingredients to.
   */
  private void addIngredientsToRecipe(Recipe recipe) {
    boolean addingIngredients = true;
    while (addingIngredients) {
      System.out.print("Add ingredients to the recipe? (yes/no):");
      String choice = scanner.nextLine();
      if (choice.equalsIgnoreCase("yes")) {
        System.out.print("Enter ingredient name: ");
        String ingredientName = scanner.nextLine();
        System.out.print("Enter ingredient quantity: ");
        double quantity = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter ingredient unit (ml, g, pcs): ");
        String unit = scanner.nextLine();
        System.out.print("Enter expiry date (yyyy-mm-dd): ");
        LocalDate expiryDate = LocalDate.parse(scanner.nextLine());

        Grocery ingredient = new Grocery(ingredientName, quantity, unit, 0, expiryDate);
        recipe.addIngredient(ingredient);

        System.out.println("Ingredient added successfully!");
      } else {
        addingIngredients = false;
        System.out.println("Finished adding ingredients.");
      }
    }
  }

  /**
   * Finds the possible recipes to make with the ingredients in the fridge.
   */
  private void possibleRecipes() {
    System.out.println("Finding recipes based on your fridge...");
    List<Recipe> recipes = cookBook.findAllPossibleRecipes(fridge);
    recipes.forEach(System.out::println);
  }

  /**
   * Method that creates a shopping list for a chosen recipe. Finds missing ingredients for the
   * chosen recipe and prints a list containing missing ingredients.
   */
  private void generateShoppingList() {
    System.out.print("Enter the name of the recipe:");
    String recipeName = scanner.nextLine().trim();

    Recipe recipe = cookBook.findRecipeByName(recipeName);
    if (recipe == null) {
      System.out.println("Recipe not found...");
      return;
    }

    Map<String, Double> missingIngredients = cookBook.getMissingIngredients(fridge);
    if (missingIngredients.isEmpty()) {
      System.out.println("You have all the ingredients for this recipe!");
    } else {
      System.out.println("\nShopping list for " + recipeName + ":");
      missingIngredients.forEach(
          (ingredient, quantity) -> System.out.println(ingredient + ": " + quantity));
    }
  }

  /**
   * Suggests recipes based on a specific macronutrient focus.
   */
  private void suggestRecipesByMacronutrient() {
    System.out.println("What type of meal do you want?");
    System.out.println("1. Carbs");
    System.out.println("2. Protein");
    System.out.println("3. Fat");
    System.out.println("Enter your choice: ");

    int choice = Integer.parseInt(scanner.nextLine().trim());
    String focus;

    switch (choice) {
      case 1:
        focus = "carbs";
        break;
      case 2:
        focus = "protein";
        break;
      case 3:
        focus = "fat";
        break;
      default:
        System.out.println("Invalid choice. Please pick a valid option.");
        return;
    }

    List<Recipe> suggestions = cookBook.suggestRecipesByMacronutrient(focus);
    System.out.println("\nSuggested recipes sorted by " + focus + ":");
    for (Recipe recipe : suggestions) {
      double nutrientValue = recipe.getNutrients().getNutrientValue(focus);
      System.out.println(recipe.getName() + " - " + focus + ": " + nutrientValue + " g");
    }
  }

  /**
   * Method for suggesting recipes using groceries that are about to expire.
   */
  private void suggestRecipesByExpiryDate() {
    System.out.println("Suggested recipes for expiring groceries:");
    List<Recipe> suggestions = cookBook.getRecipesByExpiryDate(fridge);
    if (suggestions.isEmpty()) {
      System.out.println("No recipes found for expiring groceries.");
    } else {
      suggestions.forEach(recipe -> System.out.println(recipe.getName()));
    }
  }
}
