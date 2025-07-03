package com.devops.testproj; // This package name matches your original file

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    /**
     * This is the new, testable method.
     * It contains the core logic for checking a guess against the secret number.
     * Your JUnit test file will call this method directly.
     *
     * @param guess The user's guessed number.
     * @param secretNumber The actual number to be guessed.
     * @return A string indicating if the guess was "Too low!", "Too high!", or "Correct!".
     */
    public static String checkGuess(int guess, int secretNumber) {
        if (guess < secretNumber) {
            return "Too low! Try again.";
        } else if (guess > secretNumber) {
            return "Too high! Try again.";
        } else {
            return "Correct!";
        }
    }


    /**
     * The main method now uses the checkGuess method.
     * This keeps the main loop clean and separates the testable logic.
     */
    public static void main(String[] args) {
        String[] jokes = {
            "Why was the math book sad? Because it had too many problems!",
            "Why don't scientists trust atoms? Because they make up everything!",
            "Why did the computer go to the doctor? Because it had a virus!",
            "Why was the equal sign so humble? Because it knew it wasn't less than or greater than anyone else!",
            "Why did the scarecrow win an award? Because he was outstanding in his field!"
        };

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game with Jokes!");
        System.out.println("I'm thinking of a number between 1 and 100.");

        while (true) {
            System.out.print("Guess a number: ");
            
            try {
                String input = scanner.nextLine();
                int guess = Integer.parseInt(input);
                attempts++;

                // The main loop now calls our new, testable method
                String result = checkGuess(guess, numberToGuess);
                
                // We check the result of the method to decide what to do
                if (result.equals("Correct!")) {
                    System.out.println("\nCongratulations! You guessed the number in " + attempts + " attempts.");
                    System.out.println("Here's a joke for you as a reward:");
                    
                    int jokeIndex = random.nextInt(jokes.length);
                    System.out.println(jokes[jokeIndex]);
                    
                    break; // Exit the loop
                } else {
                    // If the guess was not correct, just print the result from the method
                    System.out.println(result);
                }

            } catch (NumberFormatException e) {
                System.out.println("That's not a valid number! Please enter an integer.");
            }
        }

        scanner.close();
    }
}
