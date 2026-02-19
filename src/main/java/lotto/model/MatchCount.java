package lotto.model;

public enum MatchCount {

	NOTHING(0, false, 0),
	THREE(3, false, 5_000),
	FOUR(4, false, 50_000),
	FIVE(5, false, 1_500_000),
	FIVE_BONUS(5, true, 30_000_000),
	SIX(6, false, 2_000_000_000);

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

	public static MatchCount aggreateMatchCount(int count, boolean isContainBonus) {
		for (MatchCount match : MatchCount.values()) {
			if (match.count == count && match.bonus == isContainBonus) {
				return match;
			}
		}
		return MatchCount.NOTHING;
	}

}

