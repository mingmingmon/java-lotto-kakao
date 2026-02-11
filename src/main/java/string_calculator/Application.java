package string_calculator;

import java.math.BigInteger;
import java.util.List;

public class Application {
	public static void main(String[] args) {
		StringInput stringInput = new StringInput();

		Splitter splitter = new Splitter();
		splitter.addSplitter(stringInput.extractCustomSplitter());

		Parser parser = new Parser();
		parser.setSplitters(splitter.getSplitters());

		List<StringNumber> stringNumberList = parser.parse(stringInput.processStringInput());
		Calculator calculator = new Calculator();
		for (StringNumber number : stringNumberList) {
			calculator.add(number.value);
		}

		System.out.println(calculator.getSum());
	}
}
