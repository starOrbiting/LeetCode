package NEU.Week05;

public class linklist_SwapNodesPairs_24 {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(6);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(2);
        head.next = n1; n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6;
        ListNode newHead = swapPairs(head);

    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode swapPairs(ListNode head) {
        // 思路1：没有头节点 模拟流程，硬转
        // 特别地：第一个节点单独处理
        // 注意判断顺序(first != null && first.next != null)
//        ListNode first = head;
//        ListNode pre = head, second;
//        while (first != null && first.next != null){
//            second = first.next;
//            first.next = second.next;
//            second.next = first;
//            if (head == first){
//                head = second;
//                pre = second;
//            }
//            else {
//                pre.next = second;
//            }
//            pre = first;
//            first = first.next;
//        }
//        return head;
        // 思路2：新增头节点【需要用到上一个节点时，好用】，避免特殊处理
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode pre = newHead, first = head, second;
        while (first != null && first.next != null){
            second = first.next;
            first.next = second.next;
            second.next = first;
            pre.next = second;
            pre = first;
            first = first.next;
        }
        return newHead.next;
        // 思路3：递归
        // 链表天然的递归性
//        if (head == null || head.next == null){
//            return head;
//        }
//        ListNode second = head.next;
//        ListNode temp =second.next;
//        second.next = head;
//        head.next = swapPairs(temp);
//        return second;

    }
}
