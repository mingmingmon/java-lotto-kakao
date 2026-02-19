package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import lotto.model.DefaultLottosGenerator;
import lotto.model.LottoIssuer;
import lotto.model.LottoPrice;
import lotto.model.Lottos;
import lotto.model.LottosGenerator;
import lotto.model.Money;

class LottoIssuerTest {

	private final LottosGenerator generator = new DefaultLottosGenerator();
	private final LottoPrice lottoPrice = new LottoPrice();

	@Test
	void shouldThrowExceptionWhenManualCountIsNegative() {
		Money money = new Money(1_000);

		assertThatThrownBy(() -> new LottoIssuer(money, -1, generator, lottoPrice))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("수동 로또 개수는 음수일 수 없습니다.");
	}

	@Test
	void shouldThrowExceptionWhenMoneyIsNotEnoughToBuyAnyTicket() {
		Money money = new Money(999);

		assertThatThrownBy(() -> new LottoIssuer(money, 0, generator, lottoPrice))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("한 개의 로또도 살 수 없는 돈입니다.");
	}

	@Test
	void shouldThrowExceptionWhenManualCountExceedsTotalPurchasableCount() {
		Money money = new Money(2_000);

		assertThatThrownBy(() -> new LottoIssuer(money, 3, generator, lottoPrice))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("수동 로또 개수가 전체 구매 가능 수량을 초과했습니다.");
	}

	@Test
	void shouldThrowExceptionWhenManualInputCountDoesNotMatchManualCount() {
		Money money = new Money(5_000);
		LottoIssuer issuer = new LottoIssuer(money, 2, generator, lottoPrice);
		List<String> manualInputs = List.of("1,2,3,4,5,6");

		assertThatThrownBy(() -> issuer.issueManualLotteries(manualInputs))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("요청한 수동 로또 개수와 입력한 로또 개수가 일치하지 않습니다.");
	}

	@Test
	void shouldIssueCorrectNumberOfRandomLotteries() {
		Money money = new Money(5_000);
		LottoIssuer issuer = new LottoIssuer(money, 2, generator, lottoPrice);

		Lottos autos = issuer.issueRandomLotteries();

		assertThat(autos).hasSize(3);
	}

	@Test
	void shouldIssueManualLotteriesWhenInputCountMatchesManualCount() {
		Money money = new Money(5_000);
		LottoIssuer issuer = new LottoIssuer(money, 2, generator, lottoPrice);

		List<String> manualInputs = List.of(
			"1,2,3,4,5,6",
			"7,8,9,10,11,12"
		);

		Lottos manuals = issuer.issueManualLotteries(manualInputs);

		assertThat(manuals).hasSize(2);
	}
}
