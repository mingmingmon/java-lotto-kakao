package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.model.Buyer;
import lotto.model.Lotto;
import lotto.model.Money;

public class BuyerTest {

	@Test
	void buyWithLackAmountTest() {
		int budget = 500;
		Money money = new Money(budget);
		assertThatThrownBy(() -> Buyer.buyLotteries(money))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void buyWithExactAmountTest() {
		int budget = 14_000;
		Money money = new Money(budget);
		Buyer buyer = Buyer.buyLotteries(money);
		List<Lotto> tickets = buyer.getTickets();
		assertThat(tickets.size()).isEqualTo(14);
	}
}
