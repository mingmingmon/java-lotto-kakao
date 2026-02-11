package lotto.controller;

import lotto.*;
import lotto.model.Buyer;
import lotto.model.LotteryChecker;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.MatchCount;
import lotto.model.WinningLotto;
import lotto.view.LottoView;

import java.util.*;
import java.util.stream.Collectors;

public class LottoController {

	private final LottoView view;

	public LottoController(LottoView view) {
		this.view = view;
	}

	public void run() {
		int budget = view.readBudget();

		Buyer buyer = Buyer.buyLotteries(budget);
		List<Lotto> tickets = buyer.getTickets();
		view.printTickets(tickets);

		WinningLotto winningLotto = createWinningLotto();

		LotteryChecker checker = calculateResults(tickets, winningLotto);

		view.printStatistics(checker.getCounts(),
			checker.calculateReturnRate(budget));
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

	private LotteryChecker calculateResults(List<Lotto> tickets, WinningLotto winningLotto) {
		LotteryChecker checker = new LotteryChecker();

		for (Lotto ticket : tickets) {
			MatchCount match = winningLotto.aggreateMatchCount(ticket);
			checker.increase(match);
		}

		return checker;
	}
}
