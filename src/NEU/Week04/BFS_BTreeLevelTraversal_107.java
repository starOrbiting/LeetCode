package NEU.Week04;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_BTreeLevelTraversal_107 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
        tree.left = n1;
        tree.right = n2;
        n2.left = n3;
        n2.right = n4;
        List<List<Integer>> ans = levelOrderBottom(tree);


    }
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        /*
         * 思路：BFS
         * 注意：（1）控制一次一层要用辅助变量size，因为queue.size()是动态，不能遍历整层！！
         * （2）queue.add(node)时，要先判断node是否为null
         * （3）是!queue.isEmpty() ，不是queue != null
         */
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        if (root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            temp.clear();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
            }
            ans.add(0,new ArrayList<Integer>(temp));
        }
        return ans;
    }
}
