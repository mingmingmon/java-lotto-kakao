package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

import lotto.model.Money;

public class MoneyTest {

	@Test
	void throwExceptionIfMoneyIsNegativeNumber() {
		assertThatThrownBy(() -> new Money(-1))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
