package lotto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import lotto.model.Lotto;
import lotto.model.LottoIssuer;
import lotto.model.LottoNumber;
import lotto.model.Money;

class LottoIssuerTest {

	@Test
	void shouldThrowExceptionWhenManualCountIsNegative() {
		Money money = new Money(1000);

		assertThatThrownBy(() -> new LottoIssuer(money, -1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("수동 로또 개수는 음수일 수 없습니다.");
	}

	@Test
	void shouldThrowExceptionWhenMoneyIsNotEnoughToBuyAnyTicket() {
		Money money = new Money(999);

		assertThatThrownBy(() -> new LottoIssuer(money, 0))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("한 개의 로또도 살 수 없는 돈입니다.");
	}

	@Test
	void shouldThrowExceptionWhenManualCountExceedsTotalPurchasableCount() {
		Money money = new Money(2000);

		assertThatThrownBy(() -> new LottoIssuer(money, 3))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("수동 로또 개수가 전체 구매 가능 수량을 초과했습니다.");
	}

	@Test
	void shouldIssueManualLotteriesWhenInputCountMatchesManualCount() {
		Money money = new Money(5000);
		LottoIssuer issuer = new LottoIssuer(money, 2);
		List<String> manualInputs = List.of(
			"1,2,3,4,5,6",
			"7,8,9,10,11,12"
		);
		List<Lotto> manuals = issuer.issueManualLotteries(manualInputs);

		assertThat(manuals).hasSize(2);
		assertThat(manuals.get(0).getNumbers()).hasSize(6);
		assertThat(manuals.get(1).getNumbers()).hasSize(6);
	}

	@Test
	void shouldThrowExceptionWhenManualInputCountDoesNotMatchManualCount() {
		Money money = new Money(5000);
		LottoIssuer issuer = new LottoIssuer(money, 2);
		List<String> manualInputs = List.of("1,2,3,4,5,6");

		assertThatThrownBy(() -> issuer.issueManualLotteries(manualInputs))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("요청한 수동 로또 개수와 입력한 로또 개수가 일치하지 않습니다.");
	}

	@Test
	void shouldIssueCorrectNumberOfRandomLotteries() {
		Money money = new Money(5000);
		LottoIssuer issuer = new LottoIssuer(money, 2);
		List<Lotto> autos = issuer.issueRandomLotteries();

		assertThat(autos).hasSize(3);
		assertThat(autos).allSatisfy(lotto -> assertThat(lotto.getNumbers()).hasSize(6));
	}

	@Test
	void shouldIssueRandomLotteriesWithDistinctNumbersInEachTicket() {
		Money money = new Money(2000);
		LottoIssuer issuer = new LottoIssuer(money, 0);
		List<Lotto> autos = issuer.issueRandomLotteries();

		assertThat(autos).allSatisfy(lotto -> {
			long distinct = lotto.getNumbers().stream().distinct().count();
			assertThat(distinct).isEqualTo(6);
			assertThat(new HashSet<>(lotto.getNumbers())).hasSize(6);
		});
	}

	@Test
	void shouldIssueManualLottoUsingStaticFactory() {
		Lotto lotto = LottoIssuer.issueManualLotto("1,2,3,4,5,6");

		assertThat(lotto.getNumbers()).hasSize(6);
		assertThat(lotto.getNumbers())
			.extracting(LottoNumber::getNumber)
			.containsExactly(1, 2, 3, 4, 5, 6);
	}
}
