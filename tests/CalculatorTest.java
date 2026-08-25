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

    public static void main(String[] args) {
        assertEquals(9.0, Calculator.add(4.0, 5.0), "addition");
        assertEquals(-1.0, Calculator.subtract(4.0, 5.0), "subtraction");
        assertEquals(2.5, Calculator.divide(5.0, 2.0), "division");
        System.out.println("All " + testsRun + " calculator tests passed.");
    }
}
