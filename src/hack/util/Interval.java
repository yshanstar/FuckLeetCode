package hack.util;

public class Interval {
	public int start;
	public int end;

	public Interval(int s, int e) {
		this.start = s;
		this.end = e;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (start == end) {
			sb.append(start);
		} else {
			sb.append(start);
			sb.append("->");
			sb.append(end);
		}
		return sb.toString();
	}
}
