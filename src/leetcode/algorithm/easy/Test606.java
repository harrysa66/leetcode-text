package leetcode.algorithm.easy;

/**
 * 根据二叉树创建字符串
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * 示例 1:
 输入: 二叉树: [1,2,3,4]
    1
 /   \
 2     3
 /
 4
 输出: "1(2(4))(3)"
 解释: 原本将是“1(2(4)())(3())”，
 在你省略所有不必要的空括号对之后，
 它将是“1(2(4))(3)”。
 示例 2:
 输入: 二叉树: [1,2,3,null,4]
    1
 /   \
 2     3
 \
 4
 输出: "1(2()(4))(3)"
 解释: 和第一个示例相似，
 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 * Created by harrysa66 on 2019/2/2.
 */
public class Test606 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public String tree2str(TreeNode t) {
        if(t == null){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("(").append(t.val);
        if(t.left != null){
            builder.append("(").append(tree2str(t.left)).append(")");
        }
        if(t.right != null){
            if(t.left == null){
                builder.append("()");
            }
            builder.append("(").append(tree2str(t.right)).append(")");
        }
        builder.append(")");
        String s = builder.toString();
        return s.substring(1, s.length()-1);
    }

    public static void main(String[] args) {
        Test606 test = new Test606();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.right = new TreeNode(3);
        System.out.println(test.tree2str(treeNode));
    }
}
