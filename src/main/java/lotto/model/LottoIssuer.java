package lotto.model;

import java.util.List;

public class LottoIssuer {

	private static final int LOTTO_PRICE = 1000;

	private final Money money;
	private final int manualCount;
	private final int totalCount;
	private final LottosGenerator generator;

	public LottoIssuer(Money money, int manualCount, LottosGenerator generator) {
		this.money = money;
		validateManualCount(manualCount);
		this.manualCount = manualCount;
		this.totalCount = calculatePossibleCount(manualCount);
		this.generator = generator;
	}

	private void validateManualCount(int manualCount) {
		if (manualCount < 0) {
			throw new IllegalArgumentException("수동 로또 개수는 음수일 수 없습니다.");
		}
	}

	private int calculatePossibleCount(int manualCount) {
		int totalCount = money.getAmount() / LOTTO_PRICE;
		if (totalCount == 0) {
			throw new IllegalArgumentException("한 개의 로또도 살 수 없는 돈입니다.");
		}
		if (manualCount > totalCount) {
			throw new IllegalArgumentException("수동 로또 개수가 전체 구매 가능 수량을 초과했습니다.");
		}
		return totalCount;
	}

	public Lottos issueManualLotteries(List<String> manualInputs) {
		validateManualInputsCount(manualInputs);
		return generator.generateManual(manualInputs);
	}

	public Lottos issueRandomLotteries() {
		int autoCount = totalCount - manualCount;
		return generator.generateAuto(autoCount);
	}

	public Lottos issueAll(List<String> manualInputs) {
		return issueManualLotteries(manualInputs)
			.concat(issueRandomLotteries());
	}

	private void validateManualInputsCount(List<String> manualInputs) {
		if (manualInputs.size() != manualCount) {
			throw new IllegalArgumentException("요청한 수동 로또 개수와 입력한 로또 개수가 일치하지 않습니다.");
		}
	}
}
