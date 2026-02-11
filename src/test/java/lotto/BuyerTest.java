package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.model.Buyer;
import lotto.model.Lotto;

public class BuyerTest {

	@Test
	void buyWithLackAmountTest() {
		int budget = 500;
		assertThatThrownBy(() -> Buyer.buyLotteries(budget))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void buyWithExactAmountTest() {
		int budget = 14_000;
		Buyer buyer = Buyer.buyLotteries(budget);
		List<Lotto> tickets = buyer.getTickets();
		assertThat(tickets.size()).isEqualTo(14);
	}
}
