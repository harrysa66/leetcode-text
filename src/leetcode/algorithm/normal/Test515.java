package leetcode.algorithm.normal;

import leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 在每个树行中找最大值
 * 您需要在二叉树的每一行中找到最大的值。
 示例：
 输入:
 1
 / \
 3   2
 / \   \
 5   3   9
 输出: [1, 3, 9]
 * Created by harrysa66 on 2019/2/15.
 */
public class Test515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root != null){
            List<TreeNode> treeNodeList = new ArrayList<>();
            treeNodeList.add(root);
            getMaxVal(result, treeNodeList);
        }
        return result;
    }

    private void getMaxVal(List<Integer> result,List<TreeNode> treeNodeList){
        Integer max = null;
        List<TreeNode> tmpTreeNodeList = new ArrayList<>();
        for (TreeNode node : treeNodeList) {
            if(node != null){
                if(max == null){
                    max = node.val;
                }
                max = max > node.val ? max : node.val;
                if(node.left != null){
                    tmpTreeNodeList.add(node.left);
                }
                if(node.right != null){
                    tmpTreeNodeList.add(node.right);
                }
            }
        }
        if(!treeNodeList.isEmpty()){
            result.add(max);
        }
        if(!tmpTreeNodeList.isEmpty()){
            getMaxVal(result,tmpTreeNodeList);
        }
    }

    /**
     * 通过Queue来实现
     * @param root
     * @return
     */
    public List<Integer> largestValuesByQueue(TreeNode root) {
        List<Integer> list=new ArrayList();
        if(root==null)return list;
        Queue<TreeNode> q=new LinkedList();
        q.add(root);
        int max;
        while(!q.isEmpty()){
            int size=q.size();
            max=q.peek().val;
            while(size>0){
                TreeNode tem=q.poll();
                if(tem.val>max)max=tem.val;
                if(tem.left!=null)q.add(tem.left);
                if(tem.right!=null)q.add(tem.right);
                size--;
            }
            list.add(max);
        }
        return list;
    }

    public static void main(String[] args) {
        Test515 test = new Test515();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(9);

        List<Integer> integers = test.largestValues(treeNode);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
