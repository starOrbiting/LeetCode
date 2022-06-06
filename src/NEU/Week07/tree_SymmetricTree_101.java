package NEU.Week07;


import java.util.LinkedList;
import java.util.Queue;

public class tree_SymmetricTree_101 {
//    public boolean isSymmetric(TreeNode root) {
//        // 思路1：递归
//        // 比较左右两侧(t1.val, t2.val)(t1.left, t2.right)(t1.right, t2.left)
////        if (root == null){
////            return true;
////        }
////        return check(root.left, root.right);
////    }
////
////    public boolean check(TreeNode t1, TreeNode t2){
////        if (t1 == null && t2 == null){

////            return true;
////        }
////        if (t1 == null || t2 == null){
////            return false;
////        }
////        if (t1.val != t2.val){
////            return false;
////        }
////        return(check(t1.left, t2.right) && check(t1.right, t2.left));
//        // 思路2：迭代
//        // (1)每次提取两个结点并比较它们的值
//        // (2)然后将两个结点的左右子结点按相反的顺序插入队列中。
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.add(root);
//        queue.add(root);
//        while (!queue.isEmpty()){
//            TreeNode t1 = queue.poll();
//            TreeNode t2 = queue.poll();
//            if (t1 == null && t2 == null){
//                continue;
//            }
//            if (t1 == null || t2 == null){
//                return false;
//            }
//            if (t1.val != t2.val){
//                return false;
//            }
//            queue.add(t1.left);
//            queue.add(t2.right);
//            queue.add(t1.right);
//            queue.add(t2.left);
//        }
//        return true;
//    }
}
