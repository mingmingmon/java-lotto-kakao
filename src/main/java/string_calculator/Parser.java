package string_calculator;

import java.util.ArrayList;
import java.util.List;

public class Parser {

	private List<String> splitters;

	Parser() {
		splitters = new ArrayList<>();
	}

	void setSplitters(List<String> splitters) {
		this.splitters = splitters;
	}

	List<StringNumber> parse(String processedString) {
		List<StringNumber> numbers = new ArrayList<>();
		String regex = "[" + String.join("", this.splitters) + "]";
		String[] tokens = processedString.split(regex);

		for (String token : tokens)
			numbers.add(new StringNumber(token));

		return numbers;
	}


}
