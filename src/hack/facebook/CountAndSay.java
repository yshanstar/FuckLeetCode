package hack.facebook;

/*
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 */
public class CountAndSay {
	public String countAndSay(int n) {
		if (n < 1) {
			return "";
		}

		if (n == 1) {
			return "1";
		}

		return countAndSay("1", n - 1);
	}

	private String countAndSay(String sub, int n) {
		if (n == 0) {
			return sub;
		}

		StringBuilder sb = new StringBuilder();
		int count = 1;
		for (int i = 1; i < sub.length(); i++) {
			if (sub.charAt(i - 1) == sub.charAt(i)) {
				count++;
			} else {
				sb.append(count);
				sb.append(sub.charAt(i - 1));
				count = 1;
			}
		}

		sb.append(count);
		sb.append(sub.charAt(sub.length() - 1));

		return countAndSay(sb.toString(), n - 1);
	}
}
