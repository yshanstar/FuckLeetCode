package hack.facebook;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
Note:
The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].


Reference:
https://leetcode.com/problems/task-scheduler/solution/
https://leetcode.com/problems/task-scheduler/discuss/104496/concise-Java-Solution-O(N)-time-O(26)-space
https://leetcode.com/problems/task-scheduler/discuss/140183/Simplest-Time-Simulation-Java-O(N)-solution-Easy-to-Remember
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }

        if (n == 0) return tasks.length;

        int[] counter = new int[26];
        for (char c : tasks) {
            counter[c - 'A']++;
        }

        PriorityQueue<Integer> taskMaxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int count : counter) {
            if (count > 0) {
                taskMaxQueue.add(count);
            }
        }

        Map<Integer, Integer> timeMapTaskcount = new HashMap<>();
        int time = 0;

        while (!taskMaxQueue.isEmpty() || !timeMapTaskcount.isEmpty()) {
            if (timeMapTaskcount.containsKey(time)) {
                taskMaxQueue.add(timeMapTaskcount.remove(time));
            }

            if (!taskMaxQueue.isEmpty()) {
                int taskCount = taskMaxQueue.remove();
                if (taskCount > 1) {
                    timeMapTaskcount.put(time + n + 1, --taskCount);
                }
            }
            time++;
        }

        return time;
    }
}
