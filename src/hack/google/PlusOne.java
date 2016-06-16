package hack.google;

/*
 * Given a non-negative number represented as an array of digits, plus one to the number.
 The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return digits;
		}

		int carrier = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			int sum = digits[i] + ((i == digits.length - 1) ? 1 : 0) + carrier;
			digits[i] = sum % 10;
			carrier = sum / 10;
		}

		if (carrier == 0) {
			return digits;
		}

		int[] result = new int[digits.length + 1];
		result[0] = carrier;
		for (int i = 0; i < digits.length; i++) {
			result[i + 1] = digits[i];
		}

		return result;
	}
}
