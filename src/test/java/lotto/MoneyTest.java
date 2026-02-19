package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.model.LottoPrice;
import lotto.model.Money;

class MoneyTest {

	@Test
	void throwExceptionIfMoneyIsNegativeNumber() {
		assertThatThrownBy(() -> new Money(-1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("돈의 값은 음수일 수 없습니다.");
	}

	@Test
	void shouldCalculatePurchasableLottoCount() {
		Money money = new Money(5_000);
		LottoPrice price = new LottoPrice();

		int count = money.purchasableCount(price);

		assertThat(count).isEqualTo(5);
	}

	@Test
	void shouldReturnZeroIfNotEnoughMoney() {
		Money money = new Money(999);
		LottoPrice price = new LottoPrice();

		int count = money.purchasableCount(price);

		assertThat(count).isEqualTo(0);
	}

	@Test
	void shouldThrowIfCannotBuyAnyLotto() {
		Money money = new Money(999);
		LottoPrice price = new LottoPrice();

		assertThatThrownBy(() -> money.purchasableCountOrThrow(price))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("한 개의 로또도 살 수 없는 돈입니다.");
	}

}
