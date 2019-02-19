package leetcode.algorithm.normal;

/**
 * 水壶问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 你允许：
 装满任意一个水壶
 清空任意一个水壶
 从一个水壶向另外一个水壶倒水，直到装满或者倒空

 示例 1: (From the famous "Die Hard" example)
 输入: x = 3, y = 5, z = 4
 输出: True
 示例 2:
 输入: x = 2, y = 6, z = 5
 输出: False
 * Created by harrysa66 on 2019/2/19.
 */
public class Test365 {

    /**
     * 求x和y的最大公约数,取值能否被z整除
     * @param x
     * @param y
     * @param z
     * @return
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if(x == z || y == z || x + y == z || x - z == y || y - z == x){
            return true;
        }
        if(x + y < z){
            return false;
        }
        int gcd = GCD(x, y);
        return z % gcd == 0;
    }

    /**
     * 获取最大公约数
     * @param x
     * @param y
     * @return
     */
    private int GCD (int x, int y){
        int result = 0;
        while (y != 0) {
            result = x % y;
            x = y;
            y = result;
        }
        return x;
    }

    public static void main(String[] args) {
        Test365 test = new Test365();
        System.out.println(test.canMeasureWater(2,6,5));
    }
}
