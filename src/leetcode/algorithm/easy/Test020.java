package leetcode.algorithm.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 有效字符串需满足：
 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。
 示例 1:
 输入: "()"
 输出: true
 示例 2:
 输入: "()[]{}"
 输出: true
 示例 3:
 输入: "(]"
 输出: false
 示例 4:
 输入: "([)]"
 输出: false
 示例 5:
 输入: "{[]}"
 输出: true
 * Created by harrysa66 on 2019/2/18.
 */
public class Test020 {

    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case '(':
                    deque.addLast(s.charAt(i));
                    break;
                case '[':
                    deque.addLast(s.charAt(i));
                    break;
                case '{':
                    deque.addLast(s.charAt(i));
                    break;
                case ')':
                    Character last1 = deque.peekLast();
                    if(last1 != null && last1 == '('){
                        deque.pollLast();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    Character last2 = deque.peekLast();
                    if(last2 != null && last2 == '['){
                        deque.pollLast();
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    Character last3 = deque.peekLast();
                    if (last3 != null && last3 == '{'){
                        deque.pollLast();
                    } else {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        if(deque.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public Test020() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    /**
     * 官方题解
     * @param s
     * @return
     */
    public boolean isValid1(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Test020 test = new Test020();
        System.out.println(test.isValid(")"));
    }
}
