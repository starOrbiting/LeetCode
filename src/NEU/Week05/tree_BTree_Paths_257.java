package NEU.Week05;


import java.util.ArrayList;
import java.util.List;

public class tree_BTree_Paths_257 {
//    public List<String> binaryTreePaths(TreeNode root) {
//        // 思路：回溯
//        List<String> ans = new ArrayList<String>();
//        backtrack(ans, "", root);
//        return ans;
//    }
//    public void backtrack(List<String> ans, String temp, TreeNode root){
//        if (root == null){
//            return;
//        }
//        else {
//            // 回溯
//            StringBuilder newTemp = new StringBuilder(temp);
//            // 每次新添加字符，都是在副本上修改，不影响上一层
//            newTemp.append(Integer.toString(root.val));
//            if (root.left == null && root.right == null) {
//                ans.add(newTemp.toString());
//                return;
//            }
//            newTemp.append("->");
//            backtrack(ans, newTemp.toString(), root.left);
//            backtrack(ans, newTemp.toString(), root.right);
//
//        }
//    }
//

}
