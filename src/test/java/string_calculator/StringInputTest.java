package string_calculator;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.Test;

public class StringInputTest {

	@Test
	void extractCustomSplitter() {
		StringInput stringInput = new StringInput("//>\n123>5");
		String customSplitter = stringInput.extractCustomSplitter();
		assertThat(customSplitter).isEqualTo(">");
	}

	@Test
	void processStringInput() {
		StringInput stringInput = new StringInput("//>\n123>5");
		String result = stringInput.processStringInput();
		assertThat(result).isEqualTo("123>5");
	}
}
