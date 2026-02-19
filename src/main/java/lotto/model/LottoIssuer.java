package lotto.model;

import java.util.List;

public class LottoIssuer {

	private final Money money;
	private final int manualCount;
	private final int totalCount;
	private final LottosGenerator generator;
	private final LottoPrice lottoPrice;

	public LottoIssuer(Money money, int manualCount, LottosGenerator generator, LottoPrice lottoPrice) {
		this.money = money;
		validateManualCount(manualCount);
		this.manualCount = manualCount;
		this.generator = generator;
		this.lottoPrice = lottoPrice;
		this.totalCount = calculatePossibleCount();
	}

	private void validateManualCount(int manualCount) {
		if (manualCount < 0) {
			throw new IllegalArgumentException("수동 로또 개수는 음수일 수 없습니다.");
		}
	}

	private int calculatePossibleCount() {
		int totalCount = money.purchasableCountOrThrow(lottoPrice);
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
