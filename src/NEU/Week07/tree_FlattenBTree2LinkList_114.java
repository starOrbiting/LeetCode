//package NEU.Week07;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class tree_FlattenBTree2LinkList_114 {
//    public void flatten(TreeNode root) {
//        // 思路：先排序，后改数据结构
//        List<TreeNode> list = new ArrayList<TreeNode>();
//        dfs(list,root);
//        for (int i = 0; i < list.size() - 1; i++) {
//            TreeNode pre = list.get(i), cur = list.get(i + 1);
//            pre.left = null;
//            pre.right = cur;
//        }
//    }
//    public void dfs(List<TreeNode> list, TreeNode root){
//        if (root == null){
//            return;
//        }
//        list.add(root);
//        dfs(list, root.left);
//        dfs(list, root.right);
//    }
//}
