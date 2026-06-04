package org.johnsoncodelove;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int secretNumber = random.nextInt(100) + 1; // 1 - 100
        int maxAttempts = 5;
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("=== Number Guessing Game ===");
        System.out.println("Guess a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts.");

        while (attempts < maxAttempts) {

            System.out.print("\nEnter your guess: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            int guess = scanner.nextInt();
            attempts++;

            if (guess == secretNumber) {
                guessedCorrectly = true;
                System.out.println("Congratulations! You guessed the number.");
                System.out.println("Attempts used: " + attempts);
                break;
            } else if (guess < secretNumber) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }

            System.out.println("Attempts remaining: " + (maxAttempts - attempts));
        }

        if (!guessedCorrectly) {
            System.out.println("\nGame Over!");
            System.out.println("The correct number was: " + secretNumber);
        }

        scanner.close();
    }
}