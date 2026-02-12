package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

import lotto.model.MatchCount;

public class MatchCountTest {

	@Test
	void printStatisticsMessage() {
		MatchCount matchCount = MatchCount.THREE;
		int hits = 1;
		assertThat(matchCount.getStatisticsMessage(hits)).isEqualTo("3개 일치 (5000원)- 1개");
	}
}
