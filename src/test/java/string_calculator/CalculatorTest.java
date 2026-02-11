package string_calculator;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	void calculateTest() {
		Calculator calculator = new Calculator();
		calculator.add(new StringNumber("123").value);
		assertThat(calculator.getSum()).isEqualTo(new BigInteger("123"));
	}
}
