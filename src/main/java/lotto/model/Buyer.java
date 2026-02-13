package lotto.model;

import java.util.List;

public class Buyer {

	private final List<Lotto> tickets;

	public Buyer(List<Lotto> tickets) {
		this.tickets = List.copyOf(tickets);
	}

	public List<Lotto> getTickets() {
		return this.tickets;
	}
}
