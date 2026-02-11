package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.model.Buyer;
import lotto.model.LottoNumber;

public class LottoNumberTest {

	@Test
	void validateLottoNumberCache() {
		List<LottoNumber> lottoNumbers = LottoNumber.getCache();
		assertThat(lottoNumbers.size()).isEqualTo(45);
	}

	@Test
	void validateLottoNumberRange() {
		assertThatThrownBy(() -> new LottoNumber(50))
			.isInstanceOf(IllegalArgumentException.class);	}
}
