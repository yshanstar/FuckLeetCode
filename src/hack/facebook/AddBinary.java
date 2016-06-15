package hack.facebook;

/*
 * Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".
 */
public class AddBinary {
	public String addBinary(String a, String b) {
		if (a == null && b == null) {
			return null;
		}

		if (a.isEmpty() && b.isEmpty()) {
			return "";
		}

		if (a.isEmpty() || b.isEmpty()) {
			return (a.isEmpty()) ? b : a;
		}

		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carrier = 0;

		while (i >= 0 || j >= 0) {
			int x = (i >= 0) ? a.charAt(i--) - '0' : 0;
			int y = (j >= 0) ? b.charAt(j--) - '0' : 0;
			int digit = (x + y + carrier) % 2;
			carrier = (x + y + carrier) / 2;
			sb.insert(0, digit);
		}

		if (carrier > 0) {
			sb.insert(0, carrier);
		}

		return sb.toString();
	}
}
