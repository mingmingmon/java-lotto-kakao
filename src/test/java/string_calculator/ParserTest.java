package string_calculator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForInterfaceTypes.*;


public class ParserTest {

	@Test
	void parsing() {
		Parser parser = new Parser();
		parser.setSplitters(new ArrayList<>(List.of(":", ",")));
		String processedString = "123,5";
		List<StringNumber> parsedNumber = parser.parse(processedString);
		assertThat(parsedNumber)
			.extracting(StringNumber::getValue)
			.containsExactlyInAnyOrder(new BigInteger("123"), new BigInteger("5"));
	}
}
