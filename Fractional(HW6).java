
public class Fractional {
	public final long numerator;
	public final long denominator;

	public static final String NotANumber = "Not a Number";
	public static final String PositiveInfinity = "+Infinity";
	public static final String NegativeInfinity = "-Infinity";

	Fractional(long numerator, long denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
		}

	Fractional simplify() {
		if (isNaN()) {
			return null;
		}
		if (isInfinity()) {
			return null;
		}
		long safe;
		long h = Math.max(numerator, denominator);
		long h2 = Math.min(denominator, numerator);

		if (h == 0) {
			return new Fractional(1, 1);
		}
		while (h > h2 && h2 > 0) {
			h = h - h2;
			if (h > h2) {
				safe = h;
				h = h2;
				h2 = safe;

			}

		}

		return new Fractional(numerator / h, denominator / h);

	}

	boolean isNaN() {

		if (this.denominator == 0 && this.numerator == 0) {
			return true;
		}
		return false;
	}

	boolean isInfinity() {
		if (this.denominator == 0 && this.numerator != 0) {
			return true;
		}
		return false;
	}

	static int sign(long numerator, long denominator) {
		if (numerator == 0 && denominator == 0) {
			return 0;
		}
		if (numerator != 0 && denominator == 0) {
			if (numerator > 0) {
				return 1;
			}
			return -1;
		}

		long multiplication = numerator * denominator;
		if (multiplication < 0) {
			return -1;
		} else if (multiplication > 0) {
			return 1;
		}
		return 0;

	}

	int sign() {
		if (isInfinity()) {
			if (this.numerator > 0) {
				return 1;
			} else {
				return -1;
			}
		}
		if (isNaN()) {
			return 0;
		}

		long multiplication = this.denominator * this.numerator;
		if (multiplication < 0) {
			return -1;
		} else if (multiplication == 0) {
			return 0;
		} else {
			return 1;
		}

	}

	double getValue() {
		return (double) numerator / denominator;
	}

	@Override
	public boolean equals(Object obj) {
		Fractional s = (Fractional) obj;

		return (this.numerator / this.denominator) == (s.numerator / s.denominator);
	}

	@Override
	public String toString() {
		if (isNaN()) {
			return NotANumber;
		}
		if (isInfinity()) {
			if (sign() == +1) {
				return PositiveInfinity;
			} else {
				return NegativeInfinity;
			}
		}

		return numerator + "/" + denominator;
	}

}
