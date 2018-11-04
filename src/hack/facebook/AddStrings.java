package hack.facebook;

/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int lengthOne = num1.length() - 1;
        int lengthTwo = num2.length() - 1;

        StringBuilder sb = new StringBuilder();
        int sum = 0;
        while (lengthTwo >= 0 || lengthOne >= 0) {
            if (lengthOne >= 0) {
                sum += num1.charAt(lengthOne--) - '0';
            }

            if (lengthTwo >= 0) {
                sum += num2.charAt(lengthTwo--) - '0';
            }

            sb.append(sum % 10);
            sum = sum / 10;
        }

        if (sum != 0) {
            sb.append(sum);
        }

        return sb.reverse().toString();
    }
}
