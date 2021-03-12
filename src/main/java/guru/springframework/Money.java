package guru.springframework;

public class Money implements Expression {

	protected int amount;
	protected String currency;

	Money(int aAmount, String aCurrency) {
		amount = aAmount;
		currency = aCurrency;
	}

	@Override
	public Expression times(int aAmount) {
		return new Money(amount * aAmount, this.currency);
	}

	public String currency() {
		return currency;
	}

	static Money dollar(int aAmount) {
		return new Money(aAmount, "USD");
	}

	static Money franc(int aAmount) {
		return new Money(aAmount, "CHF");
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public boolean equals(Object obj) {
		Money money = (Money) obj;

		return amount == money.amount && currency == money.currency;
	}

	@Override
	public String toString() {

		return "Money={Amount= " + amount + ", Currency= " + currency + "}";
	}

	@Override
	public Expression plus(Expression addend) {

		return new Sum(this, addend);
	}

	public int rate(String aTo) {
		return currency.equals("CHF") && aTo.equals("USD") ? 2 : 1;
	}

	@Override
	public Money reduce(Bank aBank, String aCurrency) {
		return new Money(amount / aBank.rate(this.currency, aCurrency), aCurrency);
	}

}
