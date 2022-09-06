package util;

public class CurrencyConverter {
	public static double converter(double cotation, double dolarBought) {
		dolarBought += dolarBought / 100 * 6 ;
		return dolarBought * cotation;
	}
}
