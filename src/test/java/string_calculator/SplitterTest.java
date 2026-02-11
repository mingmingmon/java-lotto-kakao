package string_calculator;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.math.BigInteger;
import java.util.List;

import org.junit.jupiter.api.Test;

public class SplitterTest {

	@Test
	void splitTest() {
		Splitter splitter = new Splitter();
		assertThat(splitter.getSplitters()).containsAll(List.of(",", ":"));
	}

	@Test
	void addSplitterTest() {
		Splitter splitter = new Splitter();
		splitter.addSplitter(";");
		assertThat(splitter.getSplitters()).containsAll(List.of(",", ":", ";"));
	}
}
