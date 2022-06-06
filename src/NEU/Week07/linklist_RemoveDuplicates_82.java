package NEU.Week07;

public class linklist_RemoveDuplicates_82 {
//    public ListNode deleteDuplicates(ListNode head) {
//        // 思路：双指针
//        //（1）找到新数字，pre初始-101，head必是第一个新数字
//        //（2）判断cur后面是否有重复，分情况更新pre和cur
//        //（3）再进while循环的cur是下一个新数字
//        ListNode tempHead = new ListNode(-101);
//        tempHead.next = head;
//        ListNode pre = tempHead, cur = tempHead.next;
//        while(cur != null){
//            // 出现新数字
//            if (cur.val > pre.val){
//                // 判断后面有没有重复数字
//                ListNode repeat = cur.next;
//                while (repeat != null && repeat.val == cur.val){
//                  repeat = repeat.next;
//                }
//                // 更新pre和cur
//                if (cur.next != repeat){
//                    pre.next = repeat;
//                    cur = repeat;
//                }
//                else {
//                    pre = cur;
//                    cur = cur.next;
//                }
//            }
//        }
//        return tempHead.next;
//    }
}
