package NEU.Week07;

public class linklist_SortList_148 {
//    public ListNode sortList(ListNode head) {
//        // 思路：归并排序
//        //（1）递归拆分到最小元素
//        //（2）辅助头节点、合并两个链表
//       return sort(head, null);
//    }
//    public ListNode sort(ListNode head, ListNode tail){
//        if (head == null){
//            return null;
//        }
//        if (head.next == tail){
//            head.next = null;
//            return head;
//        }
//        ListNode slow = head, fast = head;
//        while (fast != tail && fast.next != tail){
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        ListNode mid = slow;
//        // mid不包含
//        ListNode l1 = sort(head, mid);
//        ListNode l2 = sort(mid, tail);
//        return merge(l1, l2);
//
//    }
//    public ListNode merge(ListNode l1, ListNode l2){
//        ListNode tempHead = new ListNode();
//        ListNode rear = tempHead;
//        while (l1 != null && l2 != null){
//            if (l1.val < l2.val){
//                rear.next = l1;
//                l1 = l1.next;
//                rear = rear.next;
//            }
//            else {
//                rear.next = l2;
//                l2 = l2.next;
//                rear = rear.next;
//            }
//        }
//        if (l1 != null){
//            rear.next = l1;
//        }
//        if (l2 != null){
//            rear.next = l2;
//        }
//        return tempHead.next;
//    }
}
