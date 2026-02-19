package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class DefaultLottosGenerator implements LottosGenerator {

	@Override
	public Lottos generateManual(List<String> inputs) {
		List<Lotto> tickets = new ArrayList<>();
		for (String input : inputs) {
			tickets.add(new Lotto(input));
		}
		return Lottos.of(tickets);
	}

	@Override
	public Lottos generateAuto(int count) {
		List<Lotto> tickets = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			tickets.add(Lotto.random());
		}
		return Lottos.of(tickets);
	}
}
