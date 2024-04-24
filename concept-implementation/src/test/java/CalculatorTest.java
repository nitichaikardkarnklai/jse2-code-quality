import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("input 1 and 1 output should be 2")
    void addShouldReturn2() {
        int result = calculator.add(1,1);
        assertEquals(2, result);
    }

    @Test
    @DisplayName("input 1 and 2 output should be 3")
    void addShouldReturn3() {
        int actual = calculator.add(1,2);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 0",
            "2, 1, 1",
            "1, 2, -1"
    })
    @DisplayName("subtract return correctly")
    void subtract(int leftOperand, int rightOperand, int expected) {
        int actual = calculator.subtract(leftOperand,rightOperand);
        assertEquals(expected, actual);
    }
}
