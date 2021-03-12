package guru.springframework;

public interface Expression {

	public Money reduce(Bank aBank, String aCurrency);

	public Expression plus(Expression addend);

	public Expression times(int aAmount);
}
