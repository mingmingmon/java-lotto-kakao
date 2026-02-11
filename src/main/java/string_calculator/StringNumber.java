package string_calculator;

import java.math.BigInteger;

public class StringNumber {
	public BigInteger value;

	StringNumber(String string) {
		if (string == null || string.isEmpty()) {
			this.value = BigInteger.ZERO;
			return;
		}
		BigInteger bigInteger = new BigInteger(string);
		if (bigInteger.signum() < 0) {
			throw new RuntimeException("음수는 불가능 합니다.");
		}
		this.value = bigInteger;
	}

	public BigInteger getValue() {
		return this.value;
	}
}
