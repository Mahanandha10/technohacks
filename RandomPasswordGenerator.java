package dow;
import java.security.SecureRandom;
import java.util.Scanner;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Random Password Generator");
        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Include uppercase letters? (Y/N): ");
        boolean includeUppercase = scanner.nextLine().equalsIgnoreCase("Y");

        System.out.print("Include lowercase letters? (Y/N): ");
        boolean includeLowercase = scanner.nextLine().equalsIgnoreCase("Y");

        System.out.print("Include digits? (Y/N): ");
        boolean includeDigits = scanner.nextLine().equalsIgnoreCase("Y");

        System.out.print("Include special characters? (Y/N): ");
        boolean includeSpecialChars = scanner.nextLine().equalsIgnoreCase("Y");

        String password = generateRandomPassword(length, includeUppercase, includeLowercase, includeDigits, includeSpecialChars);
        System.out.println("Generated Password: " + password);

        scanner.close();
    }

    private static String generateRandomPassword(int length, boolean includeUppercase, boolean includeLowercase,
                                                 boolean includeDigits, boolean includeSpecialChars) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String digitChars = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>?";

        String validChars = "";

        if (includeUppercase) {
            validChars += uppercaseChars;
        }
        if (includeLowercase) {
            validChars += lowercaseChars;
        }
        if (includeDigits) {
            validChars += digitChars;
        }
        if (includeSpecialChars) {
            validChars += specialChars;
        }

        if (validChars.isEmpty()) {
            System.out.println("Please select at least one character type.");
            return "";
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validChars.length());
            char randomChar = validChars.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}
