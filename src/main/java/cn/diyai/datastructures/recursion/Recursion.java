package cn.diyai.datastructures.recursion;

/**
 * 递归
 *
 * @author wangxiaomin
 */
public class Recursion {
    Recursion() {
    }

    public int fact(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    /**
     * 判断一个字符串是否是回文
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     * <p>
     * For example,
     * "A man, a plan, a canal: Panama"is a palindrome.
     * "race a car"is not a palindrome.
     * <p>
     * Note:
     * Have you consider that the string might be empty? This is a good question to ask during an interview.
     * <p>
     * For the purpose of this problem, we define empty string as valid palindrome.*
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        int size = s.length();
        char head;
        String h1, t1;
        String s2 = "";
        for (int i = 0; i < size; i++) {
            head = s.charAt(i);
            // 如果是字母
            if ((head >= 'a' && head <= 'z') || (head >= 'A' && head <= 'Z' )|| (head >= '0' && head <= '9')) {
                s2 = s2 + head;
            }
        }

        s2 = s2.toLowerCase();
        size = s2.length();

        if (size == 0) {
            return true;
        }

        for (int i = 0; i < size; i++) {
            // 如果是字母
            h1 = s2.charAt(i) + "";
            t1 = s2.charAt(size-i-1) + "";

            if (!h1.equals(t1)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isPalindrome2(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while ( ! isLetterOrNumber(s.charAt(i)) && i < j)
                i ++;
            while ( ! isLetterOrNumber(s.charAt(j)) && i < j)
                j --;
            if(i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i ++;
            j --;
        }
        return true;
    }

    public static boolean isLetterOrNumber(char i) {
        if(i >= '0' && i <= '9' || i >= 'a' && i <= 'z' || i >= 'A' && i <= 'Z') return true;
        return false;
    }
}
