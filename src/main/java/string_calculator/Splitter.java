package string_calculator;

import java.util.ArrayList;
import java.util.List;

public class Splitter {

	private final List<String> splitters;

	Splitter () {
		splitters = new ArrayList<>();
		this.splitters.add(":");
		this.splitters.add(",");
	}

	List<String> getSplitters() {
		return this.splitters;
	}

	void addSplitter(String newSplitter) {
		splitters.add(newSplitter);
	}
}
