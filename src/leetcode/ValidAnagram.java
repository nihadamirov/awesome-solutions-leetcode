package leetcode;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));

    }

        static boolean isAnagram(String s, String t) {

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

            Arrays.sort(s1);
            Arrays.sort(t1);

            return Arrays.equals(s1, t1);
    }
}
