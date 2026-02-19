package lotto.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto>{

	private final List<Lotto> values;

	private Lottos(List<Lotto> values) {
		this.values = new ArrayList<>(values);
	}

	public int size() {
		return values.size();
	}

	public static Lottos of(List<Lotto> values) {
		return new Lottos(values);
	}

	@Override
	public Iterator<Lotto> iterator() {
		return values.iterator();
	}

	public Lottos concat(Lottos other) {
		List<Lotto> merged = new ArrayList<>(this.values);
		merged.addAll(other.values);
		return new Lottos(merged);
	}

}

