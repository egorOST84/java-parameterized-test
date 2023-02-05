package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
// Запись @RunWith(Parameterized.class) означает, что тесты класса CalculatorTest будет запускать раннер Parameterized
public class CalculatorTest {

    private final double firstNumber;
    private final double secondNumber;
    private final double expected;

    public CalculatorTest(double firstNumber, double secondNumber, double expected) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: {0} + {1} = {2}")
    // Чтобы получать конкретные тестовые значения, нужен метод с аннотацией @Parameterized.Parameters. Он должен быть публичным и статическим
    public static Object[][] getSumData() {
        return new Object[][]{{1, 9, 10}, //Тестовые данные нужно подбирать по техникам тест-дизайна: классы эквивалентности и граничные значения.
                {1, 0, 1}, {1, -1, 0}, {-3, -3, -6}, {0, 0, 0}, {0.1, 0.9, 1}, {-0, 0, 0},};
    }

    @Test
    public void shouldBeSumTrue() {
        Calculator calculator = new Calculator();
        double actual = calculator.add(firstNumber, secondNumber);
        assertEquals(expected, actual, 0);
    }

}