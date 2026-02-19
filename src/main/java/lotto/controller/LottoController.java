package lotto.controller;

import lotto.*;
import lotto.model.LotteryChecker;
import lotto.model.Lotto;
import lotto.model.LottoIssuer;
import lotto.model.LottoNumber;
import lotto.model.LottoPrice;
import lotto.model.Lottos;
import lotto.model.LottosGenerator;
import lotto.model.MatchCount;
import lotto.model.Money;
import lotto.model.WinningLotto;
import lotto.view.LottoView;

import java.util.*;
import java.util.stream.Collectors;

public class LottoController {

	private final LottoView view;
	private final LottosGenerator lottosGenerator;
	private final LottoPrice lottoPrice;

	public LottoController(LottoView view, LottosGenerator lottosGenerator, LottoPrice lottoPrice) {
		this.view = view;
		this.lottosGenerator = lottosGenerator;
		this.lottoPrice = lottoPrice;
	}

	public void run() {
		int budget = view.readBudget();
		Money money = new Money(budget);

		int manualCount = view.readManualCount();
		List<String> manualInputs = view.readManualInputs(manualCount);

		Lottos tickets = issueLotteries(money, manualCount, manualInputs);
		view.printTickets(tickets);

		WinningLotto winningLotto = createWinningLotto();
		LotteryChecker checker = calculateResults(tickets, winningLotto);

		view.printStatistics(checker.getCounts(),
			checker.calculateReturnRate(budget));
	}

	private Lottos issueLotteries(Money money, int manualCount, List<String> manualInputs) {
		LottoIssuer lottoIssuer = new LottoIssuer(money, manualCount, lottosGenerator, lottoPrice);
		return lottoIssuer.issueAll(manualInputs);
	}

	private WinningLotto createWinningLotto() {
		String input = view.readWinningNumbers();

		List<LottoNumber> numbers = Arrays.stream(input.split(","))
			.map(String::trim)
			.map(Integer::parseInt)
			.map(LottoNumber::new)
			.collect(Collectors.toList());

		Lotto winningLotto = new Lotto(numbers);

		int bonusInput = view.readBonus();
		LottoNumber bonus = new LottoNumber(bonusInput);

		return new WinningLotto(winningLotto, bonus);
	}

	private LotteryChecker calculateResults(Lottos tickets, WinningLotto winningLotto) {
		LotteryChecker checker = new LotteryChecker();

		for (Lotto ticket : tickets) {
			MatchCount match = winningLotto.aggreateMatchCount(ticket);
			checker.increase(match);
		}

		return checker;
	}
}
