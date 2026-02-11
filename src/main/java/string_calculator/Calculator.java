package string_calculator;

import java.math.BigInteger;

public class Calculator {
	private BigInteger sum;

	Calculator() {
		this.sum = new BigInteger("0");
	}

	void add(BigInteger addend) {
		sum = sum.add(addend);
	}

	BigInteger getSum() {
		return sum;
	}
}
