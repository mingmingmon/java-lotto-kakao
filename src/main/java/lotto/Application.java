package lotto;

import lotto.controller.LottoController;
import lotto.model.DefaultLottosGenerator;
import lotto.model.LottoPrice;
import lotto.model.LottosGenerator;
import lotto.view.LottoView;

public class Application {

	public static void main(String[] args) {
		LottoView view = new LottoView();
		LottosGenerator generator = new DefaultLottosGenerator();
		LottoPrice lottoPrice = new LottoPrice();
		LottoController controller = new LottoController(view, generator, lottoPrice);
		controller.run();
	}
}
