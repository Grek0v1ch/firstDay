package ru.ac.uniyar.IvanVoronov;

public class Fraction {

	// m - числитель, целое число
	// n - знаменатель, натуральное неотрицательное число
	private int m, n;

	/**
	 * Приватный метод, который ищет наибольший общий делитель двух положительных чисел
	 * @param a первое число
	 * @param b второе число
	 * @return наибольший общий делитель чисел a и b
	 */
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

	/**
	 * Приватный метод, который сокращает дробь.
	 * */
	private void simplify() {
		int nod = getNOD(Math.abs(m), Math.abs(n));
		m /= nod;
		n /= nod;
		// Знак дроби хранится в числителе, а знаменатель всегда строго положителен.
		if (n < 0) {
			n *= -1;
			m *= -1;
		}
	}

	/**
	 * Метод проверяет, является ли дробь нулем
	 * @return true если ноль, false если не ноль
	 * */
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

	public static Fraction parseFraction(String fraction) {
		String[] data = fraction.split("/");
		if (data.length == 1) {
			return new Fraction(Integer.parseInt(data[0]));
		}
		return new Fraction(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
	}
}
