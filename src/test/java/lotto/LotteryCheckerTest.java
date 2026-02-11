package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

import lotto.model.LotteryChecker;
import lotto.model.MatchCount;

public class LotteryCheckerTest {

	@Test
	void increaseWhenThreeNumbersHit() {
		LotteryChecker lotteryChecker = new LotteryChecker();
		lotteryChecker.increase(MatchCount.THREE);
		assertThat(lotteryChecker.getCount(MatchCount.THREE)).isEqualTo(1);
	}

	@Test
	void increaseWhenFourNumbersHit() {
		LotteryChecker lotteryChecker = new LotteryChecker();
		lotteryChecker.increase(MatchCount.FOUR);
		assertThat(lotteryChecker.getCount(MatchCount.FOUR)).isEqualTo(1);
	}

	@Test
	void increaseWhenFiveNumbersHit() {
		LotteryChecker lotteryChecker = new LotteryChecker();
		lotteryChecker.increase(MatchCount.FIVE);
		assertThat(lotteryChecker.getCount(MatchCount.FIVE)).isEqualTo(1);
	}

	@Test
	void increaseWhenFiveNumbersAndBonusNumberHit() {
		LotteryChecker lotteryChecker = new LotteryChecker();
		lotteryChecker.increase(MatchCount.FIVE_BONUS);
		assertThat(lotteryChecker.getCount(MatchCount.FIVE_BONUS)).isEqualTo(1);
	}

	@Test
	void increaseWhenSixNumbersHit() {
		LotteryChecker lotteryChecker = new LotteryChecker();
		lotteryChecker.increase(MatchCount.SIX);
		assertThat(lotteryChecker.getCount(MatchCount.SIX)).isEqualTo(1);
	}

	@Test
	void calculateReturnRateTest() {
		LotteryChecker lotteryChecker = new LotteryChecker();
		lotteryChecker.increase(MatchCount.THREE);
		lotteryChecker.increase(MatchCount.FOUR);
		lotteryChecker.increase(MatchCount.FIVE);
		int totalPurchaseCost = 14000;
		double returnRate = lotteryChecker.calculateReturnRate(totalPurchaseCost);
		assertThat(returnRate).isEqualTo(111.07);
	}

}
