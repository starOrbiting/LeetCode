package NEU.Week11;

public class BDFS_CousinsBtree_993 {
    // 思路1：BFS记录层数和父节点
//    int x;
//    int y;
//    // 注意要初始值
//    int xLayer = -1;
//    int yLayer = -1;
//    TreeNode xParent = null, yParent = null;
//    boolean xFound = false, yFound = false;
//    public boolean isCousins(TreeNode root, int x, int y) {
//        this.x = x;
//        this.y = y;
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        if (root == null){
//            return false;
//        }
//
//
//
//
//        queue.offer(root);
//        int layer = -1;
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            layer++;
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//                if (node.left != null){
//                    isXY(node.left,node,layer);
//                    queue.offer(node.left);
//                }
//                if (node.right != null){
//                    queue.offer(node.right);
//                    isXY(node.right,node,layer);
//                }
//            }
//            if (xFound && yFound){
//                break;
//            }
//        }
//        return xLayer == yLayer && xParent != yParent;
//    }
//    public void isXY(TreeNode child, TreeNode parent, int layer){
//        if (child.val == x){
//            xLayer = layer;
//            xParent = parent;
//            xFound = true;
//        }
//        if (child.val == y){
//            yLayer = layer;
//            yParent = parent;
//            yFound = true;
//        }
//    }
    // 思路2：DFS记录层数和父节点
    int x;
    int y;
    int xDepth;
    int yDepth;
    TreeNode xParent;
    TreeNode yParent;
    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        DFS(root,0,null);
        return xDepth == yDepth && xParent != yParent;
    }
    public void DFS(TreeNode node, int depth, TreeNode parent){
        if (node == null){
            return;
        }
        if (node.val == x) {
            xDepth = depth;
            xParent = parent;
        }
        if (node.val == y){
            yDepth = depth;
            yParent = parent;
        }
        DFS(node.left,depth+1,node);
        DFS(node.right,depth+1,node);


    }
}














