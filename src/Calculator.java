import java.util.Locale;
import java.util.Scanner;

/**
 * Small command-line calculator used to demonstrate a complete DevOps CI workflow.
 */
public final class Calculator {
    public static final String APP_BANNER = "DevOps Calculator v1.1 - Extended and Stable";

    private Calculator() {
        // Utility class.
    }

    public static double add(double left, double right) {
        return left + right;
    }

    public static double subtract(double left, double right) {
        return left - right;
    }

    public static double multiply(double left, double right) {
        return left * right;
    }

    public static double modulo(double left, double right) {
        return left % right;
    }

    public static double divide(double left, double right) {
        if (right == 0.0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return left / right;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(APP_BANNER);
            System.out.print("Enter the first number: ");
            double left = scanner.nextDouble();
            System.out.print("Choose an operation (+, -, *, /, %): ");
            String operation = scanner.next();
            System.out.print("Enter the second number: ");
            double right = scanner.nextDouble();

            double result = switch (operation) {
                case "+" -> add(left, right);
                case "-" -> subtract(left, right);
                case "*" -> multiply(left, right);
                case "/" -> divide(left, right);
                case "%" -> modulo(left, right);
                default -> throw new IllegalArgumentException("Unsupported operation: " + operation);
            };

            System.out.printf("Result: %.2f%n", result);
        } catch (RuntimeException exception) {
            System.err.println("Calculation failed: " + exception.getMessage());
            System.exit(1);
        }
    }
}
