package hack.google;

/*
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */
public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		if (n <= 0) {
			return "";
		}

		StringBuilder sb = new StringBuilder();

		while (n > 0) {
			int tmp = n % 26;
			char c = (tmp == 0) ? 'Z' : (char) ('A' + tmp - 1);
			sb.insert(0, c);
			n = (n - 1) / 26;
		}

		return sb.toString();
	}
}
