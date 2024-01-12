import java.util.Scanner;
import java.util.Random;

public class GuessTheNumberGame1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalAttempts = 0;
        int totalRounds = 0;
        boolean playAgain = true;

        while (playAgain) {
            int lowerLimit = 1;
            int upperLimit = 100;
            int secretNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;

            int maxAttempts = 10;
            int attempts = 0;

            System.out.println("\nWelcome to the Guess the Number game!");
            System.out.printf("I've generated a number between %d and %d. Can you guess it?\n", lowerLimit, upperLimit);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == secretNumber) {
                    System.out.printf("Congratulations! You guessed the correct number in %d attempts.\n", attempts + 1);
                    totalAttempts += attempts + 1;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                attempts++;
            }

            totalRounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainChoice = scanner.next().toLowerCase();

            if (!playAgainChoice.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.printf("Game Over! You played %d round(s) with a total of %d attempts.\n", totalRounds, totalAttempts);
        scanner.close();
    }
}