package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.MatchCount;

public class LottoView {

	private final Scanner scanner = new Scanner(System.in);

	public int readBudget() {
		System.out.println("구입금액을 입력해 주세요.");
		return Integer.parseInt(scanner.nextLine());
	}

	public int readManualCount() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		return Integer.parseInt(scanner.nextLine());
	}

	public List<String> readManualInputs(int manualCount) {
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
		List<String> inputs = new ArrayList<>();
		for (int i = 0; i < manualCount; i++) {
			inputs.add(scanner.nextLine());
		}
		return inputs;
	}

	public String readWinningNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return scanner.nextLine();
	}

	public int readBonus() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return Integer.parseInt(scanner.nextLine());
	}

	public void printTickets(Lottos tickets) {
		System.out.println(tickets.size() + "개를 구매했습니다.");
		tickets.forEach(ticket -> System.out.println(ticket.getNumbers()));
	}

	public void printStatistics(Map<MatchCount, Integer> counts, double returnRate) {
		StatisticsFormatter formatter = new StatisticsFormatter();

		for (MatchCount match : MatchCount.values()) {
			int amount = counts.getOrDefault(match, 0);
			String line = formatter.format(match, amount);
			if (!line.isBlank()) {
				System.out.println(line);
			}
		}
		System.out.println("총 수익률은 " + returnRate + "입니다.");
	}
}

