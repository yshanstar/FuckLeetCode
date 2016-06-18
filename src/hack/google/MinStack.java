package hack.google;

import java.util.Stack;

/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.

 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.
 */
public class MinStack {
	Stack<Integer> stack;
	Stack<Integer> curMinStack;

	/** initialize your data structure here. */
	public MinStack() {
		this.stack = new Stack<Integer>();
		this.curMinStack = new Stack<Integer>();
	}

	public void push(int x) {
		this.stack.push(x);
		if (this.curMinStack.isEmpty() || x <= this.curMinStack.peek()) {
			this.curMinStack.push(x);
		}
	}

	public void pop() {
		int top = this.stack.pop();
		if (top <= this.curMinStack.peek()) {
			this.curMinStack.pop();
		}
	}

	public int top() {
		return this.stack.peek();
	}

	public int getMin() {
		return this.curMinStack.peek();
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);

		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}
}
