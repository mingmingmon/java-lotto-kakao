package lotto.view;

import lotto.model.MatchCount;

public class StatisticsFormatter {

	public String format(MatchCount match, int amount) {
		if (match == MatchCount.NOTHING) {
			return "";
		}

		if (match.hasBonus()) {
			return String.format("%d개 일치, 보너스 볼 일치(%d원)- %d개",
				match.getCount(), match.getPrice(), amount);
		}
		return String.format("%d개 일치 (%d원)- %d개",
			match.getCount(), match.getPrice(), amount);
	}
}
