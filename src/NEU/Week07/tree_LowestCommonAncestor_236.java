//package NEU.Week07;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//
//public class tree_LowestCommonAncestor_236 {
//    Map<Integer,TreeNode> parent = new HashMap<Integer,TreeNode>();
//    Set<Integer> visited = new HashSet<Integer>();
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        // 思路1：自底向上传递状态
//        //（1）判断某root，1）lson&&rson 2）root等于某一个，子树有包含另一个
//        //（2）向上传递状态：子树给他的，自己是否是
////        TreeNode ans = new TreeNode();
////        dfs(root,p,q,ans);
////        return ans;
////    }
////    public boolean dfs(TreeNode root, TreeNode p, TreeNode q, TreeNode ans){
////        if (root == null){
////            return false;
////        }
////        boolean lson = dfs(root.left,p,q,ans);
////        boolean rson = dfs(root.right,p,q,ans);
////        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))){
////            ans.val = root.val;
////        }
////        return lson || rson || (root.val == p.val) || (root.val == q.val);
//
//        // 思路2：链式存父节点，后续从子节点可以向上逆推
//
//        dfs(root);
//        // 从p向上记录所有的父节点值
//        // 当map找不到p的键值对时，p=null，
//        while(p != null){
//            visited.add(p.val);
//            p = parent.get(p.val);
//        }
//        // 向上找同一个祖先
//        while(q != null){
//            if (visited.contains(q.val)){
//                return q;
//            }
//            q = parent.get(q.val);
//        }
//        return null;
//
//    }
//    public void dfs(TreeNode root){
//        if (root.left != null){
//            parent.put(root.left.val, root);
//            dfs(root.left);
//        }
//        if (root.right != null){
//            parent.put(root.right.val, root);
//            dfs(root.right);
//        }
//    }
//}
