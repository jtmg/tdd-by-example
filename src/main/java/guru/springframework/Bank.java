package guru.springframework;

import java.util.HashMap;

public class Bank {

	private HashMap<Pair, Integer> rateMap = new HashMap<>();

	public Money reduce(Expression aSource, String aCurrency) {

		return aSource.reduce(this, aCurrency);
	}

	public int rate(String aFrom, String aTo) {

		return aFrom.equals(aTo) ? 1 : rateMap.get(new Pair(aFrom, aTo));
	}

	public void addRate(String aFrom, String aTo, int aRate) {
		rateMap.put(new Pair(aFrom, aTo), aRate);
	}
}
