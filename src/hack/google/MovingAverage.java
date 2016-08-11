package hack.google;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverage {
	Queue<Integer> queue;
	double avg;
	int capacity;

	/** Initialize your data structure here. */
	public MovingAverage(int size) {
		this.capacity = size;
		this.queue = new LinkedList<Integer>();
		this.avg = 0.0;
	}

	public double next(int val) {
		if (queue.size() == 0) {
			queue.offer(val);
			this.avg = (double) val;
		} else {
			double total = this.avg * queue.size();
			if (queue.size() == this.capacity) {
				total -= queue.poll();
			}

			total += val;
			this.queue.offer(val);
			this.avg = (double) (total / this.queue.size());
		}

		return this.avg;
	}
}
