package hack.facebook;

/*
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

 Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

 You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
public class FirstBadVersion {
	public int firstBadVersion(int n) {
		if (n <= 0) {
			return 0;
		}

		if (n == 1) {
			return isBadVersion(n) ? n : 0;
		}

		int result = Integer.MAX_VALUE;
		int left = 1;
		int right = n;

		/*
		 * If you use mid = (start+end)/2, (start+end) may overflow (larger than
		 * Integer.MAX_VALUE). So it is better to use mid = start+(end-start)/2
		 * in binary search.
		 */
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (isBadVersion(mid)) {
				result = Math.min(result, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		if (left == right && isBadVersion(left)) {
			result = Math.min(result, left);
		}

		return result;
	}

	// interface
	boolean isBadVersion(int version) {
		return false;
	}
}
