package hack.facebook;

/*
A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.

If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".

Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin.



Example 1:

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Example 2:

Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"


Notes:

S contains only uppercase, lowercase and spaces. Exactly one space between each word.
1 <= S.length <= 150.
 */
public class GoatLatin {
    public String toGoatLatin(String S) {
        StringBuilder result = new StringBuilder();
        if (S == null || S.length() == 0) {
            return S;
        }

        String[] segments = S.trim().split("\\s");
        for (int i = 0; i < segments.length; i++) {
            String seg = segments[i];

            if (isVowel(seg)) {
                result.append(addA(vowel(seg), i));
            } else {
                result.append(addA(consonant(seg), i));
            }

            if (i != segments.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    private String vowel(String str) {
        return str + "ma";
    }

    private String consonant(String str) {
        StringBuilder sb = new StringBuilder(str + str.charAt(0) + "ma");
        return sb.delete(0, 1).toString();
    }

    private boolean isVowel(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        char c = str.toLowerCase().charAt(0);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private String addA(String str, int count) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i <= count; i++) {
            sb.append("a");
        }
        return sb.toString();
    }
}
