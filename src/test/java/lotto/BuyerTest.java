package lotto;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.model.Buyer;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class BuyerTest {

	@Test
	void shouldCreateBuyerWithGivenTickets() {
		Lotto lotto1 = new Lotto("1,2,3,4,5,6");
		Lotto lotto2 = new Lotto("7,8,9,10,11,12");

		Lottos tickets = Lottos.of(List.of(lotto1, lotto2));
		Buyer buyer = new Buyer(tickets);

		assertThat(buyer.tickets()).hasSize(2);
		assertThat(buyer.tickets()).containsExactly(lotto1, lotto2);
	}
}
