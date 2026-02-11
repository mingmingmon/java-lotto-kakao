package lotto;

import lotto.controller.LottoController;
import lotto.view.LottoView;

public class Application {

	public static void main(String[] args) {
		LottoView view = new LottoView();
		LottoController controller = new LottoController(view);
		controller.run();
	}
}
