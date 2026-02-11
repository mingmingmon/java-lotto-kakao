package lotto.model;

public enum MatchCount {

	NOTHING(0, false, 0),
	THREE(3, false, 5000),
	FOUR(4, false, 50000),
	FIVE(5, false, 1500000),
	FIVE_BONUS(5, true, 30000000),
	SIX(6, false, 2000000000);

	private final int count;
	private final boolean bonus;
	private final int price;

	MatchCount(int count, boolean bonus, int price) {
		this.count = count;
		this.bonus = bonus;
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public boolean hasBonus() {
		return bonus;
	}

	public int getPrice() {
		return price;
	}

}

