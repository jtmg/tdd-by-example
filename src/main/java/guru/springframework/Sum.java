package guru.springframework;

public class Sum implements Expression {

	Expression augmend;
	Expression addmend;

	Sum(Expression aAugmend, Expression aAddmend) {
		augmend = aAugmend;
		addmend = aAddmend;
	}

	@Override
	public Money reduce(Bank aBank, String aCurrency) {
		int amount = augmend.reduce(aBank, aCurrency).amount + addmend.reduce(aBank, aCurrency).amount;
		return new Money(amount, aCurrency);
	}

	@Override
	public Expression plus(Expression addend) {

		return new Sum(this, addend);
	}

	@Override
	public Expression times(int aAmount) {

		return new Sum(augmend.times(aAmount), addmend.times(aAmount));
	}

}
