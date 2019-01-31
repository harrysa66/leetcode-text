package leetcode.algorithm.normal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 一手顺子
 * 爱丽丝有一手（hand）由整数数组给定的牌。
 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 如果她可以完成分组就返回 true，否则返回 false。
 * 示例 1：
 输入：hand = [1,2,3,6,2,3,4,7,8], W = 3
 输出：true
 解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 示例 2：
 输入：hand = [1,2,3,4,5], W = 4
 输出：false
 解释：爱丽丝的手牌无法被重新排列成几个大小为 4 的组。
 * 提示：
 1 <= hand.length <= 10000
 0 <= hand[i] <= 10^9
 1 <= W <= hand.length
 * Created by harrysa66 on 2019/1/30.
 */
public class Test846 {
    public boolean isNStraightHand(int[] hand, int W) {
        boolean flag = false;
        if(W == 1){
            return true;
        }
        if(hand.length % W != 0){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(hand);
        for (int i = 0; i < hand.length; i++) {
            if(map.containsKey(i)){
                continue;
            }
            for (int k = 1; k < W; k++) {
                flag = false;
                for (int j = i + k; j < hand.length; j++) {
                    if((hand[j] - hand[i]) == k && !map.containsKey(j)){
                        flag = true;
                        map.put(j,hand[j]);
                        break;
                    } else if((hand[j] - hand[i]) > k){
                        return false;
                    }
                }
                if(!flag){
                    return false;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Test846 test = new Test846();
        //int[] hand = {1,2,3,6,2,3,4,7,8};
        int[] hand = {1,2,2,3,3,4,4,5,5,6,6,7};
        System.out.println(test.isNStraightHand(hand,3));
    }
}
