package hack.google;

import java.util.Iterator;

/*
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

Call next() gets you 1, the first element in the list.

Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.
 */
public class PeekingIterator implements Iterator<Integer> {
	private Iterator<Integer> iterator;
	private Integer num;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		this.iterator = iterator;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (num == null) {
			num = next();
		}
		return num;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return num != null || iterator.hasNext();
	}

	@Override
	public Integer next() {
		if (num != null) {
			Integer res = num;
			num = null;
			return res;
		}

		return iterator.next();
	}

}
