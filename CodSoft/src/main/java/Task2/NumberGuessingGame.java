package Task2;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Generate a random number between 1 and 100
        int gameNumber = random.nextInt(100) + 1;
        int userGuess;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the correct number between 1 and 100.");

        do {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();

            if (userGuess < gameNumber) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > gameNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guess the correct number: " + gameNumber);
            }

        } while (userGuess != gameNumber);

        scanner.close();
    }
}
