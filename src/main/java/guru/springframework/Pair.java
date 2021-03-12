package guru.springframework;

import java.util.Objects;

public class Pair {

	private final String from;
	private final String to;

	Pair(String aFrom, String aTo) {
		from = aFrom;
		to = aTo;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Pair pair = (Pair) obj;

		return Objects.equals(from, pair.from) && Objects.equals(to, pair.to);
	}

	@Override
	public int hashCode() {

		return Objects.hash(from, to);
	}

}
