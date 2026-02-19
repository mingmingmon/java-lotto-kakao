package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import lotto.model.DefaultLottosGenerator;
import lotto.model.LottoNumber;
import lotto.model.Lottos;
import lotto.model.LottosGenerator;

class DefaultLottosGeneratorTest {

	private final LottosGenerator generator = new DefaultLottosGenerator();

	@Test
	void shouldGenerateManualLottosFromInputs() {
		List<String> inputs = List.of(
			"1,2,3,4,5,6",
			"7,8,9,10,11,12"
		);

		Lottos manuals = generator.generateManual(inputs);

		assertThat(manuals).hasSize(2);

		List<Integer> first = manuals.iterator().next().getNumbers().stream()
			.map(LottoNumber::getNumber)
			.toList();
		assertThat(first).containsExactly(1, 2, 3, 4, 5, 6);
	}

	@Test
	void shouldGenerateAutoLottosWith6DistinctNumbersEach() {
		Lottos autos = generator.generateAuto(10);

		assertThat(autos).hasSize(10);
		assertThat(autos).allSatisfy(lotto -> {
			assertThat(lotto.getNumbers()).hasSize(6);
			assertThat(new HashSet<>(lotto.getNumbers())).hasSize(6);
		});
	}
}
