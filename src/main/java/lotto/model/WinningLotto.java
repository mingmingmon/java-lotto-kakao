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
		return MatchCount.aggreateMatchCount(count, isContainBonus);
	}
}
