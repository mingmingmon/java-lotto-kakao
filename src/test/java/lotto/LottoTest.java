package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.model.Lotto;
import lotto.model.LottoNumber;

public class LottoTest {

	@Test
	void createRandomLottoTest() {
		Lotto lotto = Lotto.random();
		List<LottoNumber> lottoNumbers = lotto.getNumbers();

		assertThat(lottoNumbers).hasSize(6);
	}

	@Test
	void isAscending() {
		Lotto lotto = Lotto.random();
		List<LottoNumber> lottoNumbers = lotto.getNumbers();

		int size = lottoNumbers.size();
		for (int i = 0; i < size - 1; i++) {
			assertThat(lottoNumbers.get(i).getNumber())
				.isLessThan(lottoNumbers.get(i + 1).getNumber());
		}
	}

	@Test
	void createManualLottoTest() {
		Lotto lotto = new Lotto("1,2,3,4,5,6");

		List<Integer> numbers = lotto.getNumbers().stream()
			.map(LottoNumber::getNumber)
			.toList();

		assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
	}
}
