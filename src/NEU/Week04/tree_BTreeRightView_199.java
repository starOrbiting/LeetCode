package NEU.Week04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class tree_BTreeRightView_199 {
//    public List<Integer> rightSideView(TreeNode root) {
//        /*
//         * 思路1：BFS广度优先
//         * （1）每层的最后一个节点值加入ans
//         * （2）用队列每次存储一层，遍历本层存储下一层
//         */
////        List<Integer> ans = new ArrayList<Integer>();
////        if (root == null){
////            return ans;
////        }
////        Queue<TreeNode> queue = new LinkedList<TreeNode>();
////        queue.add(root);
////        while (!queue.isEmpty()){
////            int size = queue.size();
////            for (int i = 0; i < size; i++) {
////                TreeNode node = queue.poll();
////                if (node.left != null){
////                    queue.add(node.left);
////                }
////                if (node.right != null){
////                    queue.add(node.right);
////                }
////                if (i == size - 1){
////                    ans.add(node.val);
////                }
////            }
////        }
////        return ans;
//        /*
//         * 思路2：DFS深度优先
//         * （1）根右左遍历，每个深度放一个节点，如果该深度已有值，不放
//         */
//        List<Integer> ans = new ArrayList<Integer>();
//        dfs(root, ans, 0);
//        return ans;
//    }
//    public void dfs(TreeNode root, List<Integer> ans, int depth){
//        if (root == null){
//            return;
//        }
//        if (depth == ans.size()){
//            ans.add(root.val);
//        }
//        depth++;
//        dfs(root.right, ans, depth);
//        dfs(root.left, ans, depth);
//    }

}

























