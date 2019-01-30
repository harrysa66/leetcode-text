package leetcode.algorithm.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 输入: "babad"
 输出: "bab"
 注意: "aba" 也是一个有效答案。
 示例 2：
 输入: "cbbd"
 输出: "bb"
 * Created by harrysa66 on 2019/1/29.
 */
public class Test005 {

    /**
     * 遍历字符串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.equals("")){
            return "";
        }
        String result = "";
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            List<Integer> list = new ArrayList<>();
            if (map.containsKey(s.charAt(i))){
                list = map.get(s.charAt(i));
                for (Integer index : list) {
                    String substring = s.substring(index, i + 1);
                    if(substring.equals(getReverseString(substring)) && substring.length() > result.length()){
                        result = substring;
                    }
                }
            }
            list.add(i);
            map.put(s.charAt(i),list);
        }
        if (result.equals("")){
            result = s.substring(0,1);
        }
        return result;
    }

    /**
     * 得到逆序字符串
     * @param s
     * @return
     */
    private String getReverseString(String s){
        if (s == null){
            return null;
        }
        StringBuilder builder = new StringBuilder(s);
        return builder.reverse().toString();
    }

    /**
     * 中心扩展算法(官方题解)
     * 事实上，只需使用恒定的空间，我们就可以在O(n^2)的时间内解决这个问题。
     我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有2n - 1个这样的中心。
     你可能会问，为什么会是2n - 1个，而不是n个中心？原因在于所含字母数为偶数的回文的中心可以处于两字母之间（例如“abba”的中心在两个‘b’之间）。
     * 复杂度分析
     时间复杂度：O(n^2)，由于围绕中心来扩展回文会耗去O(n)的时间，所以总的复杂度为 O(n^2)。
     空间复杂度：O(1)。
     * @param s
     * @return
     */
    public String longestPalindromeByExpandAroundCenter(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 围绕中心扩展
     * @param s
     * @param left
     * @param right
     * @return
     */
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        Test005 test005 = new Test005();
        System.out.println(test005.longestPalindrome(""));
    }
}
