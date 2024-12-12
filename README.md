STUDENT NAME = Ola Syrstad Berg 
STUDENT ID = 119533

## Project description

This project serves as the end assignment for the course IDATT1003. The project revolves around creating an application that helps make consumers a little more aware of their own food waste. The food contains the following information:
```
Grocery - The grocery, or ingredient, that is used in a recipe.
Information about the groceries include:
          Name - The name of the grocery - e.g. "Milk".
          Unit - The unit used by the grocery - e.g. "grams".
          Price - The price of individual groceries.
          Quantity - The quantity of a grocery.
          Expiration date - The expiration date of the groceries.

Recipe - The recipes that can be made witht the groceries available.
Information about the recipes include:
          Name - The name of the recipe - e.g. "Waffles".
          Description - The description of the recipe - e.g. "Crispy Waffles".
          Procedure - The procedure for how to make the recipe - e.g. "Mix and cook".
          Time - The time it takes to make each recipe.
          Servings - The amount of servings you can make with the recipe.
          Nutrients - The nutrients that the recipe contains.
```
The program is limited to use a text-based user interface. 
The user interface allows the user to limit their own food waste by giving them an overview of the groceries they have in their fridge, their amount and their expiry date.
Using that information the program can suggest recipes that can be made to limit food waste.

## Project structure

Source files are stored in src/main/java/edu.ntnu.idi.bidata this is where you can find all of the classes used by the application.
Test files are stored in src/test/java/edu.ntnu.idi.bidata this is where you can find all of the test classes.
The main program is the Application class.

## Link to repository

https://github.com/NTNU-IDI/idatt1003-mappe-2024-Ola-S-Berg

## How to run the project

To run the project open Application and run the file. The program should then start in the terminal with instructions for the different menu options.

## How to run the tests

Navigate to the test classes as described in the project structure. You should find 6 classes. Select the class you want to run and press "run".

## References

Cay Horstmann, Core Java: Fundamentals, Volume , Chapter 7: Exceptions, Assertions, and Logging.
https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
https://docs.oracle.com/javase/8/docs/api/java/util/Map.html
https://www.youtube.com/watch?v=xk4_1vDrzzo
https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
