public final class CalculatorTest {
    private static int testsRun = 0;

    private CalculatorTest() {
        // Test utility class.
    }

    private static void assertEquals(double expected, double actual, String testName) {
        testsRun++;
        if (Math.abs(expected - actual) > 0.000001) {
            throw new AssertionError(
                testName + " failed: expected " + expected + " but received " + actual
            );
        }
        System.out.println("PASS: " + testName);
    }

    private static void assertThrows(Runnable action, String expectedMessage, String testName) {
        testsRun++;
        try {
            action.run();
            throw new AssertionError(testName + " failed: expected an exception");
        } catch (IllegalArgumentException exception) {
            if (!expectedMessage.equals(exception.getMessage())) {
                throw new AssertionError(
                    testName + " failed: unexpected message " + exception.getMessage()
                );
            }
        }
        System.out.println("PASS: " + testName);
    }

    public static void main(String[] args) {
        assertEquals(9.0, Calculator.add(4.0, 5.0), "addition");
        assertEquals(-1.0, Calculator.subtract(4.0, 5.0), "subtraction");
        assertEquals(20.0, Calculator.multiply(4.0, 5.0), "multiplication");
        assertEquals(2.5, Calculator.divide(5.0, 2.0), "division");
        assertThrows(
            () -> Calculator.divide(5.0, 0.0),
            "Division by zero is not allowed",
            "division by zero validation"
        );
        System.out.println("All " + testsRun + " calculator tests passed.");
    }
}
