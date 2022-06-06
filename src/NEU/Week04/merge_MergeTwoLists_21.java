package NEU.Week04;


public class merge_MergeTwoLists_21 {
    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n4.next = n5;
        n5.next = n6;
        ListNode n8 = null;
        ListNode n9 = null;

        ListNode l = mergeTwoLists(n8, n9);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 思路1：归并排序
        // 没有头节点的插入，要返回ans.next，才能避免一些问题
//        ListNode ans = new ListNode();
//        ans.next = null;
//        ListNode cur = ans;
//        while (list1 != null && list2 != null) {
//            if (list1.val < list2.val) {
//
//                cur.next = list1;
//                cur = cur.next;
//                list1 = list1.next;
//            } else {
//                cur.next = list2;
//                cur = cur.next;
//                list2 = list2.next;
//
//            }
//        }
//        if (list1 != null) {
//            cur.next = list1;
//        }
//        if (list2 != null) {
//            cur.next = list2;
//
//        }
//        return ans.next;
        // 思路2：递归
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        if (list1.val < list2.val){
            // list以后排好序
            list1.next = mergeTwoLists(list1.next, list2);
            // 此处return，是返回当前list给上一个节点
            return list1;
        }
        else{
            list2.next = mergeTwoLists(list2.next, list1);
            return list2;
        }
    }
}
















