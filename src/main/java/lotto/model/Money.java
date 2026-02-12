package lotto.model;

public class Money {

	private final int amount;

	public Money(int amount) {
		validate(amount);
		this.amount = amount;
	}

	public void validate(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("돈의 값은 음수일 수 없습니다.");
		}
	}

	public int getAmount() {
		return amount;
	}
}
