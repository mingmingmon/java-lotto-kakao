package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoIssuer {

	private static final int LOTTO_PRICE = 1000;

	private final Money money;
	private final int manualCount;
	private final int totalCount;

	public LottoIssuer (Money money, int manualCount) {
		this.money = money;
		validateManualCount(manualCount);
		this.manualCount = manualCount;
		this.totalCount = calculatePossibleCount(manualCount);
	}

	public void validateManualCount(int manualCount) {
		if (manualCount < 0) {
			throw new IllegalArgumentException("수동 로또 개수는 음수일 수 없습니다.");
		}
	}

	public int calculatePossibleCount(int manualCount) {
		int totalCount = money.getAmount() / LOTTO_PRICE;
		if (totalCount == 0) {
			throw new IllegalArgumentException("한 개의 로또도 살 수 없는 돈입니다.");
		}
		if (manualCount > totalCount) {
			throw new IllegalArgumentException("수동 로또 개수가 전체 구매 가능 수량을 초과했습니다.");
		}
		return totalCount;
	}

	public List<Lotto> issueManualLotteries(List<String> manualInputs) {
		if (manualInputs.size() != manualCount) {
			throw new IllegalArgumentException("요청한 수동 로또 개수와 입력한 로또 개수가 일치하지 않습니다.");
		}

		List<Lotto> tickets = new ArrayList<>();
		for (String input : manualInputs) {
			tickets.add(issueManualLotto(input));
		}

		return tickets;
	}

	public List<Lotto> issueRandomLotteries() {
		List<Lotto> tickets = new ArrayList<>();
		int autoCount = totalCount - manualCount;
		for (int i = 0; i < autoCount; i++) {
			tickets.add(issueRandomLotto());
		}
		return tickets;
	}

	public static Lotto issueManualLotto(String input) {
		return Lotto.createManualLotto(input);
	}

	public static Lotto issueRandomLotto() {
		return Lotto.createRandomLotto();
	}
}
