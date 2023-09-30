package dow;
import java.util.Scanner;
public class BasicCalculator {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Basic Calculator");
	       System.out.print("Enter the first number: ");
	        double num1 = scanner.nextDouble();

	        System.out.print("Enter the operator (+, -, *, /): ");
	        char operator = scanner.next().charAt(0);

	        System.out.print("Enter the second number: ");
	        double num2 = scanner.nextDouble();

	        double result;

	        switch (operator) {
	            case '+':
	                System.out.println("Result: " + (num1 + num2));
	                break;
	            case '-':
	       	        System.out.println("Result: " + (num1 - num2));
	                break;
	            case '*':
	                
	                System.out.println("Result: " + (num1 * num2));
	                break;
	            case '/':
	                if (num2 != 0) {
	                System.out.println("Result: " + (num1 / num2));
	                }
	                else {
	                System.out.println("Error: Division by zero.");
	                }
	                break;
	            default:
	                System.out.println("Invalid operator. Please enter +, -, *, or /.");
	                break;
	        }

	        scanner.close();
	    }
	}


