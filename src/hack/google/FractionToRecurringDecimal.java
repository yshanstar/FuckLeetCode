package hack.google;

import java.util.HashMap;
import java.util.Map;

/*
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class FractionToRecurringDecimal {
	public static String fractionToDecimal(int numerator, int denominator) {
		if (denominator == 0) {
			return "";
		}

		if (numerator == 0) {
			return "0";
		}

		StringBuilder sb = new StringBuilder();

		if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
			sb.append("-");
		}

		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);

		long n = num / den;
		sb.append(n);

		long reminder = num % den;
		if (reminder == 0) {
			return sb.toString();
		}

		sb.append(".");

		Map<Long, Integer> map = new HashMap<Long, Integer>();

		while (!map.containsKey(reminder)) {
			map.put(reminder, sb.length());
			n = reminder * 10 / den;
			reminder = reminder * 10 % den;

			if (reminder != 0 || (reminder == 0 && !map.containsKey(reminder))) {
				sb.append(n);
			}
		}

		if (reminder != 0) {
			sb.insert(map.get(reminder), "(");
			sb.append(")");
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(fractionToDecimal(1, 13));
	}
}
