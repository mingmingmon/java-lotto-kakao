package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.model.Lotto;
import lotto.model.LottoNumber;

public class LottoTest {

	@Test
	void createRandomLottoTest() {
		Lotto lotto = Lotto.createRandomLotto();
		List<LottoNumber> lottoNumbers = lotto.getNumbers();
		assertThat(lottoNumbers.size()).isEqualTo(6);
	}

	@Test
	void isAscending() {
		Lotto lotto = Lotto.createRandomLotto();
		List<LottoNumber> lottoNumbers = lotto.getNumbers();

		int size = lottoNumbers.size();
		for (int i = 0; i < size - 1; i++) {
			assertThat(lottoNumbers.get(i).getNumber())
				.isLessThan(lottoNumbers.get(i + 1).getNumber());
		}
	}

	@Test
	void createManualLottoTest() {
		String input = "1,2,3,4,5,6";
		Lotto lotto = Lotto.createManualLotto(input);
		List<Integer> numbers = lotto.getNumbers().stream()
			.map(LottoNumber::getNumber)
			.toList();
		assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
	}

}
