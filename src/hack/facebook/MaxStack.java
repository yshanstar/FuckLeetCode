package hack.facebook;

import java.util.Stack;

/*
Design a max stack that supports push, pop, top, peekMax and popMax.

push(x) -- Push element x onto stack.
pop() -- Remove the element on top of the stack and return it.
top() -- Get the element on the top.
peekMax() -- Retrieve the maximum element in the stack.
popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
Example 1:
MaxStack stack = new MaxStack();
stack.push(5);
stack.push(1);
stack.push(5);
stack.top(); -> 5
stack.popMax(); -> 5
stack.top(); -> 1
stack.peekMax(); -> 5
stack.pop(); -> 1
stack.top(); -> 5


Reference:
https://leetcode.com/problems/max-stack/discuss/108938/Java-AC-solution
https://leetcode.com/problems/max-stack/discuss/129922/Java-simple-solution-with-strict-O(logN)-push()popMax()pop()

 */
public class MaxStack {
    /**
     * initialize your data structure here.
     */

    private Stack<Integer> stack;
    private Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        pushHelper(x);
    }

    private void pushHelper(int x) {
        int temMax = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
        if (temMax < x) {
            temMax = x;
        }
        stack.push(x);
        maxStack.push(temMax);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.peek();

        Stack<Integer> tmpStack = new Stack<>();
        while (stack.peek() != max) {
            tmpStack.push(stack.pop());
            maxStack.pop();
        }
        stack.pop();
        maxStack.pop();

        while (!tmpStack.isEmpty()) {
            int x = tmpStack.pop();
            pushHelper(x);
        }
        return max;
    }
}
