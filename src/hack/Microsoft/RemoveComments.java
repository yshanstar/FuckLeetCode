package hack.Microsoft;

import java.util.ArrayList;
import java.util.List;


// Reference: https://leetcode.com/problems/remove-comments/discuss/109197/One-pass-solution-in-Java
public class RemoveComments {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean commentMode = false;

        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if (commentMode) {
                    if (s.charAt(i) == '*' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        commentMode = false;
                        i++; // skil '/' on next iteration of i
                    }
                } else {
                    if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        break;
                    } else if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '*') {
                        commentMode = true;
                        i++; // skip the '*' on next iteration
                    } else {
                        sb.append(s.charAt(i));
                    }
                }
            }
            if (!commentMode && sb.length() > 0) {
                result.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return result;
    }
}
