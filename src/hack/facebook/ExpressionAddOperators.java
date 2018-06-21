package hack.facebook;

import java.util.ArrayList;
import java.util.List;

/*
Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Example 1:

Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"]
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]
Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]
Example 4:

Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]
Example 5:

Input: num = "3456237490", target = 9191
Output: []

Reference:
https://leetcode.com/problems/expression-add-operators/discuss/71895/Java-Standard-Backtrace-AC-Solutoin-short-and-clear
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }

        helper(result, "", num, target, 0, 0, 0);

        return result;
    }

    private void helper(List<String> result, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval) {
                result.add(path);
            }
            return;
        }

        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(result, path + cur, num, target, i + 1, cur, cur);
            } else {
                helper(result, path + "+" + cur, num, target, i + 1, eval + cur, cur);
                helper(result, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
                helper(result, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }

    public static void main (String[] args){
        ExpressionAddOperators expressionAddOperators = new ExpressionAddOperators();
        expressionAddOperators.addOperators("105", 5);
    }
}
