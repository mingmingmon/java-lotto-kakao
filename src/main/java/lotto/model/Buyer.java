package lotto.model;

public class Buyer {

	private final Lottos tickets;

	public Buyer(Lottos tickets) {
		this.tickets = tickets;
	}

	public Lottos tickets() {
		return tickets;
	}
}
