package leetcode.algorithm.easy;

/**
 * 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 字符          数值
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 输入: "III"
 输出: 3
 示例 2:
 输入: "IV"
 输出: 4
 示例 3:
 输入: "IX"
 输出: 9
 示例 4:
 输入: "LVIII"
 输出: 58
 解释: L = 50, V= 5, III = 3.
 示例 5:
 输入: "MCMXCIV"
 输出: 1994
 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * Created by harrysa66 on 2019/2/14.
 */
public class Test013 {
    public int romanToInt(String s) {
        int sum = 0;
        if(s == null || s.length() == 0){
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'I' && i < s.length()-1 && s.charAt(i+1) == 'V'){
                sum = sum + 4;
                i = i + 1;
                continue;
            }else if(s.charAt(i) == 'I' && i < s.length()-1 && s.charAt(i+1) == 'X'){
                sum = sum + 9;
                i = i + 1;
                continue;
            }else if(s.charAt(i) == 'I'){
                sum = sum + 1;
            }
            if(s.charAt(i) == 'V'){
                sum = sum + 5;
            }
            if(s.charAt(i) == 'X' && i < s.length()-1 && s.charAt(i+1) == 'L'){
                sum = sum + 40;
                i = i + 1;
                continue;
            }else if(s.charAt(i) == 'X' && i < s.length()-1 && s.charAt(i+1) == 'C'){
                sum = sum + 90;
                i = i + 1;
                continue;
            }else if(s.charAt(i) == 'X'){
                sum = sum + 10;
            }
            if(s.charAt(i) == 'L'){
                sum = sum + 50;
            }
            if(s.charAt(i) == 'C' && i < s.length()-1 && s.charAt(i+1) == 'D'){
                sum = sum + 400;
                i = i + 1;
                continue;
            }else if(s.charAt(i) == 'C' && i < s.length()-1 && s.charAt(i+1) == 'M'){
                sum = sum + 900;
                i = i + 1;
                continue;
            }else if(s.charAt(i) == 'C'){
                sum = sum + 100;
            }
            if(s.charAt(i) == 'D'){
                sum = sum + 500;
            }
            if(s.charAt(i) == 'M'){
                sum = sum + 1000;
            }
        }
        return sum;
    }

    /**
     * 采用switch
     * @param s
     * @return
     */
    public int romanToInt2(String s) {
        int sum = 0;
        if(s == null || s.length() == 0){
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case 'I':
                    if(i != s.length() - 1 && s.charAt(i+1) == 'V'){
                        sum = sum + 4;
                        i = i + 1;
                    }else if (i != s.length() - 1 && s.charAt(i+1) == 'X'){
                        sum = sum + 9;
                        i = i + 1;
                    }else{
                        sum = sum + 1;
                    }
                    break;
                case 'V':
                    sum = sum + 5;
                    break;
                case 'X':
                    if(i != s.length() - 1 && s.charAt(i+1) == 'L'){
                        sum = sum + 40;
                        i = i + 1;
                    }else if (i != s.length() - 1 && s.charAt(i+1) == 'C'){
                        sum = sum + 90;
                        i = i + 1;
                    }else{
                        sum = sum + 10;
                    }
                    break;
                case 'L':
                    sum = sum + 50;
                    break;
                case 'C':
                    if(i != s.length() - 1 && s.charAt(i+1) == 'D'){
                        sum = sum + 400;
                        i = i + 1;
                    }else if (i != s.length() - 1 && s.charAt(i+1) == 'M'){
                        sum = sum + 900;
                        i = i + 1;
                    }else{
                        sum = sum + 100;
                    }
                    break;
                case 'D':
                    sum = sum + 500;
                    break;
                case 'M':
                    sum = sum + 1000;
                    break;
                default:
                    break;
            }
        }
        return sum;
    }

    /**
     * 评论中其他人题解
     * @param s
     * @return
     */
    public int romanToIntOther(String s) {
        int n = s.length();
        int roman_int = 0;
        for(int i=0;i<n;i++)
        {
            switch(s.charAt(i))
            {
                case 'I' : roman_int = roman_int + 1;break;
                case 'V' : roman_int = roman_int + 5;break;
                case 'X' : roman_int = roman_int + 10;break;
                case 'L' : roman_int = roman_int + 50;break;
                case 'C' : roman_int = roman_int + 100;break;
                case 'D' : roman_int = roman_int + 500;break;
                case 'M' : roman_int = roman_int + 1000;break;
                default: System.out.println("default");break;
            }

            if(i!=0)
            {
                if(((s.charAt(i)=='V')||(s.charAt(i)=='X'))&&(s.charAt(i-1)=='I'))
                    roman_int = roman_int-1*2;
                if(((s.charAt(i)=='L')||(s.charAt(i)=='C'))&&(s.charAt(i-1)=='X'))
                    roman_int = roman_int-10*2;
                if(((s.charAt(i)=='D')||(s.charAt(i)=='M'))&&(s.charAt(i-1)=='C'))
                    roman_int = roman_int-100*2;
            }
        }
        return roman_int;
    }

    public static void main(String[] args) {
        Test013 test = new Test013();
        System.out.println(test.romanToInt2("MCMXCIV"));
    }
}
