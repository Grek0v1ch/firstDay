import org.junit.jupiter.api.Test;
import ru.ac.uniyar.IvanVoronov.Main;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
	@Test
	void addition() {
		String actual = Main.calculate("1", "+", "1");
		assertEquals("2", actual);
	}

	@Test
	void additionDifferentSign() {
		String actual = Main.calculate("1", "+", "-1");
		assertEquals("0", actual);
	}

	@Test
	void subtraction() {
		String actual = Main.calculate("1", "-", "1");
		assertEquals("0", actual);
	}

	@Test
	void multiplication() {
		String actual = Main.calculate("2", "*", "2");
		assertEquals("4", actual);
	}

	@Test
	void division() {
		String actual = Main.calculate("4", "/", "2");
		assertEquals("2", actual);
	}

	@Test
	void divisionByOne() {
		String actual = Main.calculate("4", "/", "1");
		assertEquals("4", actual);
	}

	@Test
	void divisionByZero() {
		String actual = Main.calculate("4", "/", "0");
		assertEquals("Деление на ноль!", actual);
	}

	@Test
	void additionFraction() {
		String actual = Main.calculate("4/3", "+", "2/3");
		assertEquals("2", actual);
	}

	@Test
	void additionFractionDifferentSign() {
		String actual = Main.calculate("4/3", "+", "-2/3");
		assertEquals("2/3", actual);
	}

	@Test
	void subtractionFraction() {
		String actual = Main.calculate("4/3", "-", "2/3");
		assertEquals("2/3", actual);
	}

	@Test
	void subtractionFractionDifferentSign() {
		String actual = Main.calculate("4/3", "-", "-2/3");
		assertEquals("2", actual);
	}

	@Test
	void multiplicationFraction() {
		String actual = Main.calculate("1/3", "*", "2/3");
		assertEquals("2/9", actual);
	}

	@Test
	void multiplicationFractionDifferentSign() {
		String actual = Main.calculate("1/3", "*", "-2/3");
		assertEquals("-2/9", actual);
	}

	@Test
	void divisionFraction() {
		String actual = Main.calculate("4/2", "/", "1/2");
		assertEquals("4", actual);
	}

	@Test
	void divisionFractionDifferentSign() {
		String actual = Main.calculate("4/2", "/", "-1/2");
		assertEquals("-4", actual);
	}

	@Test
	void divisionFractionByZero() {
		String actual = Main.calculate("4/2", "/", "0");
		assertEquals("Деление на ноль!", actual);
	}
}
