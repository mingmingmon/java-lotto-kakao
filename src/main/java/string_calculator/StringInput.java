package string_calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringInput {
	private String input;

	StringInput(String string) {
		this.input = string;
	}

	StringInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("문자열을 입력하세요");

		String firstLine = scanner.nextLine();
		this.input = firstLine;

		if (firstLine.startsWith("//")) {
			this.input += "\n" + scanner.nextLine();
		}
	}

	String extractCustomSplitter() {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(this.input);
		if (m.find()) {
			return m.group(1);
		}
		return null;
	}

	String processStringInput() {
		String processedString = this.input;
		return processedString.replaceFirst("//(.)\\n", "");
	}

}
