package hack.facebook;

/*
 * The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function will only be called once for each test case.
 */
public class Reader4 {
	/**
	 * @param buf
	 *            Destination buffer
	 * @param n
	 *            Maximum number of characters to read
	 * @return The number of characters read
	 */
	public int read(char[] buf, int n) {
		int total = 0;
		char[] tmp = new char[4];
		boolean eof = false;

		while (!eof && total < n) {
			int count = read4(tmp);

			eof = count < 4;

			count = Math.min(count, n - total);

			for (int i = 0; i < count; i++) {
				buf[total++] = tmp[i];
			}
		}

		return total;
	}

	int read4(char[] buf) {
		return Integer.MIN_VALUE;
	}
}
