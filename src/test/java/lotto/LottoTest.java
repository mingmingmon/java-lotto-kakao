package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.model.Lotto;
import lotto.model.LottoNumber;

public class LottoTest {

	@Test
	void createLottoTest() {
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

}
