import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    void testAddWithNegativeNumbers() {
        // Arrange
        String numbers = "-1,2,-3";

        // Act & Assert
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> StringCalculator.add(numbers));
        String expectedMessage = "Negatives not allowed: -1, -3";
        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void testAddWithNumbersGreaterThan1000() {
        // Arrange
        String numbers = "100,200,3000,4000,50000";

        // Act
        int result = StringCalculator.add(numbers);

        // Assert
        int expectedSum = 300;
        Assertions.assertEquals(expectedSum, result);
    }
}
