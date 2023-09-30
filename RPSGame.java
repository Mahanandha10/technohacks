package dow;
import java.util.Random;
import java.util.Scanner;

public class RPSGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] options = {"Rock", "Paper", "Scissors"};

        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("Enter your choice (Rock, Paper, or Scissors):");
        String userChoice = scanner.nextLine();

        int computerChoiceIndex = random.nextInt(3);
        String computerChoice = options[computerChoiceIndex];
        System.out.println("Computer chooses: " + computerChoice);
        String result = determineWinner(userChoice, computerChoice);
        System.out.println(result);

        scanner.close();
    }

    private static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equalsIgnoreCase(computerChoice)) {
            return "It's a tie!";
        } else if ((userChoice.equalsIgnoreCase("Rock") && computerChoice.equalsIgnoreCase("Scissors")) ||
                   (userChoice.equalsIgnoreCase("Scissors") && computerChoice.equalsIgnoreCase("Paper")) ||
                   (userChoice.equalsIgnoreCase("Paper") && computerChoice.equalsIgnoreCase("Rock"))) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}

