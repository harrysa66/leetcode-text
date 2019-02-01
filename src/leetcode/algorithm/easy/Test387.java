package leetcode.algorithm.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 案例:
 s = "leetcode"
 返回 0.
 s = "loveleetcode",
 返回 2.
 * Created by harrysa66 on 2019/2/1.
 */
public class Test387 {
    public int firstUniqChar(String s) {
        int result = -1;
        if(s.length() == 1){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int index = s.indexOf(s.codePointAt(i), i + 1);
            if (!set.add(s.charAt(i))){
                continue;
            }
            if(index < 0){
                return i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Test387 test = new Test387();
        System.out.println(test.firstUniqChar("aadadaad"));
    }
}
