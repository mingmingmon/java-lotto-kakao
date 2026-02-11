package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import lotto.model.Lotto;
import lotto.model.MatchCount;

public class LottoView {

	private final Scanner scanner = new Scanner(System.in);

	public int readBudget() {
		System.out.println("구입금액을 입력해 주세요.");
		return Integer.parseInt(scanner.nextLine());
	}

	public String readWinningNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return scanner.nextLine();
	}

	public int readBonus() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return Integer.parseInt(scanner.nextLine());
	}

	public void printTickets(List<Lotto> tickets) {
		System.out.println(tickets.size() + "개를 구매했습니다.");
		tickets.forEach(ticket -> System.out.println(ticket.getNumbers()));
	}

	public void printStatistics(Map<MatchCount, Integer> counts, double returnRate) {
		System.out.println("당첨 통계");
		System.out.println("3개 일치 (5000원)- " + counts.getOrDefault(MatchCount.THREE, 0) + "개");
		System.out.println("4개 일치 (50000원)- " + counts.getOrDefault(MatchCount.FOUR, 0) + "개");
		System.out.println("5개 일치 (1500000원)- " + counts.getOrDefault(MatchCount.FIVE, 0) + "개");
		System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + counts.getOrDefault(MatchCount.FIVE_BONUS, 0) + "개");
		System.out.println("6개 일치 (2000000000원)- " + counts.getOrDefault(MatchCount.SIX, 0) + "개");
		System.out.println("총 수익률은 " + returnRate + "입니다.");
	}
}

