package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Buyer {

	private final List<Lotto> tickets;
	private final static int LOTTO_PRICE = 1_000;

	Buyer(List<Lotto> tickets) {
		this.tickets = List.copyOf(tickets);
	}

	public static Buyer buyLotteries(int budget) {
		List<Lotto> tickets = new ArrayList<>();
		int amount = budget / LOTTO_PRICE;
		if (amount == 0) {
			throw new IllegalArgumentException("한 개의 로또도 살 수 없는 돈입니다.");
		}
		while (amount-- > 0) {
			tickets.add(Lotto.createRandomLotto());
		}
		return new Buyer(tickets);
	}

	public List<Lotto> getTickets() {
		return this.tickets;
	}
}
