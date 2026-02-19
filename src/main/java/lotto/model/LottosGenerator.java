package lotto.model;

import java.util.List;

public interface LottosGenerator {
	Lottos generateManual(List<String> inputs);
	Lottos generateAuto(int count);
}
