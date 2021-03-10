package guru.springframework;

public class Dollar {

	private int amount;

	Dollar(int aAmount) {
		setAmount(aAmount);
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void times(int i) {

		amount *= i;

	}

}
