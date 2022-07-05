package ru.ac.uniyar.IvanVoronov;

public class Fraction {
	private int m, n;

	private int getNOD(int a, int b) {
		if (a == 0) {
			return b;
		}
		if (b == 0) {
			return a;
		}
		if (a > b) {
			return getNOD(a % b, b);
		} else {
			return getNOD(a, b % a);
		}
	}

	private void simplify() {
		int nod = getNOD(Math.abs(m), Math.abs(n));
		m /= nod;
		n /= nod;
		if (n < 0) {
			n *= -1;
			m *= -1;
		}
	}

	public boolean isZero() {
		return m == 0;
	}

	public Fraction(int m, int n) {
		this.m = m;
		this.n = n;
		if (this.n == 0) {
			this.m = 0;
			this.n = 1;
		}
		simplify();
	}

	public Fraction(int m) {
		this.m = m;
		n = 1;
	}

	public Fraction sum(Fraction value) {
		return new Fraction(m * value.n + value.m * n, n * value.n);
	}

	public Fraction dif(Fraction value) {
		return new Fraction(m * value.n - value.m * n, n * value.n);
	}

	public Fraction multiply(Fraction value) {
		return new Fraction(m * value.m, n * value.n);
	}

	public Fraction div(Fraction value) {
		return new Fraction(m * value.n, n * value.m);
	}

	@Override
	public String toString() {
		if (n == 1)
			return  Integer.toString(m);
		else
			return m + "/" + n;
	}
}
