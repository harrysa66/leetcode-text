package leetcode.algorithm.normal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:
 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:
 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * Created by harrysa66 on 2019/1/29.
 */
public class Test003 {

    /**
     *  移动下标进行计算
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null){
            return 0;
        }
        int subLength = 0;
        int charAtValue = 0;
        int count = 0;
        char[] chars = s.toCharArray();
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            String key = String.valueOf(chars[i]);
            if (map.containsKey(key) && map.get(key) >= charAtValue){
                count = i - charAtValue;
                if (count > subLength){
                    subLength = count;
                }
                charAtValue = map.get(key) + 1;
                map.remove(key);
                map.put(key, i);
            } else {
                map.put(key, i);
                if (i == chars.length - 1){
                    count = i - charAtValue + 1;
                    if (count > subLength){
                        subLength = count;
                    }
                }
            }
        }
        return subLength;
    }

    /**
     * 方法一：暴力法(官方题解)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringByAll(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    private boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    /**
     * 方法二：滑动窗口(官方题解)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringBySlide(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 方法三：优化的滑动窗口(官方题解)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringByBetterSlide(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /**
     * 假设字符集为 ASCII 128(官方题解)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringByASCII(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
