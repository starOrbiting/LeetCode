package DataStructure.class02_LinkedList;

public class Code03_JosephuLinkedList {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
//        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.Josephy(1,2,5);
    }

}
class CircleSingleLinkedList {
    private BoyNode first = null;
    // 1. 添加节点,构成环形
    public void addBoy(int num) {
        if (num < 1){
            System.out.println("num值不正确");
            return;
        }
        BoyNode cur = null;
        for (int i = 1; i <= num; i++) {
            // 根据编号，创建小孩节点
            BoyNode boyNode = new BoyNode(i);
            if (i == 1) {
                first = boyNode;
                boyNode.setNext(first);
                cur = first;
            }
            else {
                cur.setNext(boyNode);
                boyNode.setNext(first);
                cur = boyNode;
            }
        }
    }
    // 2. 遍历打印节点
    public void showBoy() {
        if (first == null) {
            System.out.println("链表空");
            return;
        }
        // first不能动，需要辅助变量cur
        BoyNode cur = first;
        while (true) {
            System.out.printf("小孩编号是%d\n", cur.getNo());
            if (cur.getNext() == first){
                break;
            }
            cur = cur.getNext();
        }
    }
    // 3. 出队列,需要保存前一个节点
    /*
     * 【1. helper指向最后一个节点】【2. 报数前helper和first向后移动k-1次】
     * 【3. while(直到first.next == first时停止){
     * 【4. helper.next = first.next; first = first.next】【5. 直到first.next == first时停止】}】
     * 【6. 退出循环，剩最后一个】
     */
    public void Josephy(int startNo, int CountNum, int nums) {
        // 合理性校验
        if (first == null || startNo < 1 || startNo > nums || CountNum < 0){
            System.out.println("参数有误");
            return;
        }
        // ps：校验是否全部出去
        int x = 0;
        BoyNode helper = first;
        // （1）helper指向最后一个
        while (helper.getNext() != first){
            helper = helper.getNext();
        }
        // （2）报数前，移动k-1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        // （3）（4）（5）while循环
        while (first.getNext() != first) {
            // （3）数m个数，移动m-1次
            for (int i = 0; i < CountNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // （4）first是要出去的节点，helper是前一个节点
            System.out.printf("出去的小孩是%d\n", first.getNo());
            x++;
            helper.setNext(first.getNext());
            first = first.getNext();
        }
        // （5）退出循环，只剩最后一个
        System.out.printf("最后出去的小孩是%d\n", first.getNo());
        x++;
        System.out.printf("一共有%d人，出去%d人\n", nums, x);
        return;

    }


}

class BoyNode{
    private int no;
    private BoyNode next;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public BoyNode getNext() {
        return next;
    }

    public void setNext(BoyNode next) {
        this.next = next;
    }

    public BoyNode(int no) {
        this.no = no;
    }
}