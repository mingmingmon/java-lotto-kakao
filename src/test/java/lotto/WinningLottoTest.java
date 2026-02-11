package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.model.Buyer;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.WinningLotto;

public class WinningLottoTest {

	List<LottoNumber> numbers = Arrays.asList(
		new LottoNumber(1),
		new LottoNumber(2),
		new LottoNumber(3),
		new LottoNumber(4),
		new LottoNumber(5),
		new LottoNumber(6)
	);

	Lotto winningNumbers = new Lotto(numbers);
	LottoNumber bonus = LottoNumber.getCache().get(6);
	WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);

	@Test
	void winningLottoTest() {
		assertThat(winningNumbers.getNumbers().size()).isEqualTo(6);
	}

	@Test
	void lotteryNumberListCheckerTest() {
		List<LottoNumber> ticketNumber = Arrays.asList(
			new LottoNumber(1),
			new LottoNumber(2),
			new LottoNumber(3),
			new LottoNumber(4),
			new LottoNumber(5),
			new LottoNumber(6)
		);
		Lotto ticket = new Lotto(ticketNumber);
		int hits = winningLotto.checkNumbers(ticket);
		assertThat(hits).isEqualTo(6);
	}

	@Test
	void lotteryBonusCheckerTest() {
		List<LottoNumber> ticketNumber = Arrays.asList(
			new LottoNumber(1),
			new LottoNumber(2),
			new LottoNumber(3),
			new LottoNumber(4),
			new LottoNumber(5),
			new LottoNumber(7)
		);
		Lotto ticket = new Lotto(ticketNumber);
		boolean isContainBonus = winningLotto.isContainBonus(ticket);
		assertThat(isContainBonus).isEqualTo(true);
	}

	@Test
	void throwExceptionWhenBonusBallDuplicate() {
		LottoNumber bonus = LottoNumber.getCache().get(5);
		assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonus))
			.isInstanceOf(IllegalArgumentException.class);
	}

}
