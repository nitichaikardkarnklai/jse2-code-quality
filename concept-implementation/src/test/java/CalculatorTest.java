import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    @DisplayName("1 + 1 = 2")
    void addShouldReturn2() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.add(1,1);

        // Assert
        assertEquals(2, result);
    }

    @Test
    @DisplayName("input 1 and 2 output should be 3")
    void addShouldReturn3() {
        Calculator calculator = new Calculator();
        int actual = calculator.add(1,2);
        int expected = 3;
        assertEquals(expected, actual);
    }
}
