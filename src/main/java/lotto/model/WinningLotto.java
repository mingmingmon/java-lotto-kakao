package lotto.model;

public class WinningLotto {

	private final Lotto winningNumbers;
	private final LottoNumber bonus;

	public WinningLotto(Lotto winningNumbers, LottoNumber bonus) {
		validate(winningNumbers, bonus);
		this.winningNumbers = winningNumbers;
		this.bonus = bonus;
	}

	private void validate(Lotto winningNumbers, LottoNumber bonus) {
		if (winningNumbers.getNumbers().contains(bonus)) {
			throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
		}
	}

	public int checkNumbers(Lotto tickets) {
		return winningNumbers.countMatch(tickets);
	}

	public boolean isContainBonus(Lotto tickets) {
		return tickets.isContainBonusBall(bonus);
	}

	public MatchCount aggreateMatchCount(Lotto tickets) {
		int count = checkNumbers(tickets);
		boolean isContainBonus = isContainBonus(tickets);
		if (count == MatchCount.SIX.getCount()) {
			return MatchCount.SIX;
		}
		if (count == MatchCount.FIVE_BONUS.getCount() && isContainBonus == MatchCount.FIVE_BONUS.hasBonus()) {
			return MatchCount.FIVE_BONUS;
		}
		if (count == MatchCount.FIVE.getCount()) {
			return MatchCount.FIVE;
		}
		if (count == MatchCount.FOUR.getCount()) {
			return MatchCount.FOUR;
		}
		if (count == MatchCount.THREE.getCount()) {
			return MatchCount.THREE;
		}
		return MatchCount.NOTHING;
	}
}
