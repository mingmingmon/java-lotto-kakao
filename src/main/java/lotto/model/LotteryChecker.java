package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class LotteryChecker {

	private final Map<MatchCount, Integer> counts = new EnumMap<>(MatchCount.class);
	private static final int DIGIT = 100;

	public LotteryChecker() {
		for (MatchCount match : MatchCount.values()) {
			counts.put(match, 0);
		}
	}

	public void increase(MatchCount matchCount) {
		counts.put(matchCount, counts.get(matchCount) + 1);
	}

	public int getCount(MatchCount matchCount) {
		return counts.get(matchCount);
	}

	public int calculateTotalPrize() {
		int sum = 0;
		for (MatchCount match : MatchCount.values()) {
			sum += counts.get(match) * match.getPrice();
		}
		return sum;
	}

	public Map<MatchCount, Integer> getCounts() {
		return this.counts;
	}

	public double calculateReturnRate(int totalPurchaseCost) {
		int totalPrize = calculateTotalPrize();
		double rate = (double) totalPrize / totalPurchaseCost;
		return Math.round(rate * DIGIT) / (double)DIGIT;
	}

}
