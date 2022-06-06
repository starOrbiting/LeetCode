//package NEU.Week07;
//
//import java.util.Deque;
//import java.util.LinkedList;
//
//public class tree_PopulateNextPointer_116 {
//    public Node connect(Node root) {
//        // 思路：BFS，每层链接
//        if (root == null){
//            return null;
//        }
//        Deque<Node> queue = new LinkedList<Node>();
//        queue.add(root);
//        Node pre = new Node();
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                if (i == 0){
//                    pre = queue.poll();
//
//                }
//                else {
//                    pre.next = queue.poll();
//                    pre = pre.next;
//                }
//                if (pre.left != null){
//                    queue.add(pre.left);
//
//                }
//                if (pre.right != null){
//                    queue.add(pre.right);
//                }
//
//            }
//        }
//        return root;
//    }
//}
