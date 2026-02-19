package lotto.model;

public class Money {

	private final int amount;

	public Money(int amount) {
		validate(amount);
		this.amount = amount;
	}

	private void validate(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("돈의 값은 음수일 수 없습니다.");
		}
	}

	public int purchasableCountOrThrow(LottoPrice price) {
		int count = purchasableCount(price);
		if (count == 0) {
			throw new IllegalArgumentException("한 개의 로또도 살 수 없는 돈입니다.");
		}
		return count;
	}

	public int purchasableCount(int unitPrice) {
		validateUnitPrice(unitPrice);
		return amount / unitPrice;
	}

	public int purchasableCount(LottoPrice price) {
		return purchasableCount(price.value());
	}

	private void validateUnitPrice(int unitPrice) {
		if (unitPrice <= 0) {
			throw new IllegalArgumentException("단가는 0 이하일 수 없습니다.");
		}
	}
}
