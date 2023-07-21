import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Task1{
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            int score = 0;

            System.out.println("Lets play Number Game");

            boolean playAgain = true;
            while (playAgain) {
                int min, max, Attempts;

               
                System.out.print("\nEnter the minimum range: ");
                min = scanner.nextInt();
                System.out.print("Enter the maximum range: ");
                max = scanner.nextInt();
                System.out.print("Attempts you wanna try: ");
                Attempts = scanner.nextInt();

                
                scanner.nextLine();

                int generatedNumber = random.nextInt(max - min + 1) + min;
                int attempts = 0;
                boolean guessedCorrectly = false;
                System.out.println("\nI have generated a number between " + min + " and " + max + ".");
                System.out.println("You have " + Attempts + " attempts to guess the number.");

                while (attempts < Attempts && !guessedCorrectly) {
                    System.out.print("\nEnter your guess: ");
                    int userGuess;
                    try {
                        userGuess = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter a valid number.");
                        scanner.nextLine(); 

                        continue;
                    }
                    scanner.nextLine();

                    if (userGuess < generatedNumber) {
                        System.out.println("It's Too low!");
                    } else if (userGuess > generatedNumber) {
                        System.out.println("it's Too high!");
                    } else {
                        System.out.println("Congratulations! You guessed the correct number.");
                        guessedCorrectly = true;
                        score++;
                    }

                    attempts++;
                }

                if (!guessedCorrectly) {
                    System.out.println("\nGame over! You ran out of attempts.");
                    System.out.println("The correct number was: " + generatedNumber);
                }

                System.out.print("\nDo you want to play again? (yes/no): ");
                String playAgainResponse = scanner.nextLine();

                if (!playAgainResponse.equalsIgnoreCase("yes")) {
                    playAgain = false;
                }
            }

            System.out.println("\nGame over! Your score is: " + score);
        }
        System.out.println("Thank you for playing the Number Game!");
    }
}
