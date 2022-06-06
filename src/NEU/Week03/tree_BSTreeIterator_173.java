package NEU.Week03;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class tree_BSTreeIterator_173 {
    class BSTIterator {
        // 读懂题意！！为什么用全局变量？只有全局变量能判断程序进度
        // 两种方法本质一样 递归 栈实现
        /*
         * 思路1，直接中序遍历，结果存到数组里，判断有无下一个直接看数组长度
         */
//        public List<Integer> arr;
//        public int index;

//        public BSTIterator(TreeNode root) {
//            index = 0;
//            arr = new ArrayList<Integer>();
//            inorderTraversal(root, arr);
//
//        }
//        public void inorderTraversal(TreeNode root, List<Integer> arr){
//            if (root == null){
//                return;
//            }
//            inorderTraversal(root.left, arr);
//            arr.add(root.val);
//            inorderTraversal(root.right, arr);
//        }
//
//        public int next() {
//            return arr.get(index++);
//        }
//
//        public boolean hasNext() {
//            return index < arr.size();
//
//        }
        /*
         * 思路2：找到最底层左节点，向上递推
         */
//        Stack<TreeNode> stack;
//        TreeNode cur;
//        public BSTIterator(TreeNode root) {
//            stack = new Stack<TreeNode>();
//            cur = root;
//        }
//
//        public int next() {
//            //
//            // （1）找每个分支最左边的节点
//            while (cur != null){
//                stack.push(cur);
//                cur = cur.left;
//            }
//            // （2）pop每个分支的根节点
//            cur = stack.pop();
//            int val = cur.val;
//            // （3）遍历右节点（相当于上一节点的全部左子树遍历完成），遍历完返回上一层根节点，再遍历上一层右子树
//            cur = cur.right;
//            return val;
//
//        }
//
//        public boolean hasNext() {
//            // !stack.isEmpty()：是否有上一层
//            // cur != null：右子树是否还有
//            return !stack.isEmpty() || cur != null;
//        }
    }
}
