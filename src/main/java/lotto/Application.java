package lotto;

import lotto.controller.LottoController;
import lotto.model.DefaultLottosGenerator;
import lotto.model.LottosGenerator;
import lotto.view.LottoView;

public class Application {

	public static void main(String[] args) {
		LottoView view = new LottoView();
		LottosGenerator generator = new DefaultLottosGenerator();
		LottoController controller = new LottoController(view, generator);
		controller.run();
	}
}
