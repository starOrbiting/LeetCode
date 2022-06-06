package DataStructure.class02_LinkedList;


import java.util.Stack;

public class Code01_SingleLinkedList {
    /**
     * 1. 获取单链表有效节点个数（不统计头节点）
     *【遍历】
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode temp = head.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;

    }

    /**
     * 2. 查找链表倒数第k个节点
     * 【先获得总长度，再length-k+1就是正序，找不到就返回null】
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 3. 单链表的反转（头插法）
     * 【新建一个链表，在遍历原链表时，每次取原链表节点，插入新链表的第一个位置】
     */
    public static void reverseLink(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            System.out.println("不需要反转");
            return;
        }
        HeroNode cur = head.next;
        HeroNode reverseHead = new HeroNode(0, "", "");
        HeroNode last = null;
        while (cur != null) {
            last = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = last;
        }
//        head = reverseHead;
        head.next = reverseHead.next;
        return;
    }

    /**
     * 通过遍历，同时反转
     */
    public static void reverseLink2(HeroNode head) {
        if (head.next == null) {
            System.out.println("不需要反转");
            return;
        }
        HeroNode pre = null;
        HeroNode temp = null;
        HeroNode cur = head.next;
        while (cur != null) {
            head.next = cur;
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return;
    }

    /**
     * 4. 从尾到头打印链表
     * （1）先反转单链表，直接打印，会破坏原来单链表结构，不建议
     * （2）栈结构，先进后出特点
     */
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            System.out.println("空链表");
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
        return;
    }

    /**
     * 5. 合并两个有序单链表
     * 【归并排序】，无序也可归并
     */
    public static HeroNode mergeLink(HeroNode head1, HeroNode head2) {
        HeroNode mergeHead = new HeroNode(0, "", "");

        HeroNode p1 = head1.next;
        HeroNode p2 = head2.next;
        HeroNode cur = mergeHead;
        HeroNode temp = null;
        while (p1 != null && p2 != null) {
            if (p1.no < p2.no) {
                temp = p1.next;
                p1.next = cur.next;
                cur.next = p1;
                cur = cur.next;
                p1 = temp;
            } else {
                temp = p2.next;
                p2.next = cur.next;
                cur.next = p2;
                cur = cur.next;
                p2 = temp;
            }
        }
        if (p1 != null) {
            cur.next = p1;
        } else {
            cur.next = p2;
        }
        return mergeHead;

    }

    public static void main(String[] args) {
        // 1. 创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        // 2. 创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(5, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(8, "林冲", "豹子头");
        HeroNode hero10 = new HeroNode(8, "林冲", "豹子头");

        // 3. 添加测试 队尾添加
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.showList();
        // 3. 添加测试 按编号顺序添加
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero10);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.showList();
        System.out.println(hero3);

        // 4. 修改测试 修改节点
//        System.out.println("修改节点后-----");
//        HeroNode hero5 = new HeroNode(4, "林冲", "豹子头-----------");
//        singleLinkedList.update(hero5);
//        singleLinkedList.showList();

        // 5. 删除测试 删除节点
//        System.out.println("删除节点后------------------");
//        singleLinkedList.delete(1);
//        singleLinkedList.showList();
//        singleLinkedList.delete(4);
//        singleLinkedList.showList();
//        singleLinkedList.delete(4);
//        singleLinkedList.showList();
//        singleLinkedList.delete(2);
//        singleLinkedList.delete(3);
//        singleLinkedList.delete(3);
//        singleLinkedList.showList();

        // 面试题测试---------------------------------
        // 1. 返回链表的有效节点个数（遍历）
//        System.out.println("返回有效个数测试--------------------");
//        System.out.println("有效个数：" + getLength(singleLinkedList.getHead()));
        // 2. 返回倒数第k个节点（数学）
//        System.out.println("返回倒数第k个测试--------------------");
//        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 3);
//        System.out.println("倒数 res: " + res);
        // 3. 反转链表（头插、遍历）
//        System.out.println("反转测试---------------------");
//        singleLinkedList.showList();
//        reverseLink2(singleLinkedList.getHead());
//        singleLinkedList.showList();
        // 4. 逆序打印（栈）
//        System.out.println("逆序打印测试--------------------");
//        reversePrint(singleLinkedList.getHead());
        // 5. 合并两个有序链表（归并）
//        System.out.println("合并有序链表测试--------------");
//        SingleLinkedList s1 = new SingleLinkedList();
//        HeroNode hero6 = new HeroNode(3, "卢俊义", "玉麒麟");
//        HeroNode hero7 = new HeroNode(6, "吴用", "智多星");
//        HeroNode hero8 = new HeroNode(9, "林冲", "豹子头");
//        HeroNode hero9 = new HeroNode(1, "宋江", "及时雨");
//        s1.addByOrder(hero6);
//        s1.addByOrder(hero7);
//        s1.addByOrder(hero8);
//        s1.addByOrder(hero9);
//        System.out.println("链表1------------");
//        singleLinkedList.showList();
//        System.out.println("链表2------------");
//        s1.showList();
//        System.out.println("合并链表3----------------");
//        SingleLinkedList s2 = new SingleLinkedList();
//        s2.setHead(mergeLink(singleLinkedList.getHead(), s1.getHead()));
//        s2.showList();

    }
}

// 定义SingleLinkedList来管理我们的 Node节点。
class SingleLinkedList {
    // 1. 先初始化一个头节点，头节点不要动,不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    // 返回头节点
    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    // 2. 队尾添加：找到链表最后，最后的next指向新的节点
    public  void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    // 3. 按顺序添加节点
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            if (heroNode.no == temp.no) {
                System.out.printf("编号%d已经存在，不能插入\n", heroNode.no);
                return;
            } else if (temp.next.no > heroNode.no) {
                break;
            }
            temp = temp.next;
        }
        // 最后从while出来的temp，是待插入位置的前一个节点
        // 如果插入元素和队尾元素编号一样，需要单独判断
        if (heroNode.no == temp.no){
            System.out.printf("编号%d已经存在，不能插入\n", heroNode.no);
            return;
        }
        heroNode.next = temp.next;
        temp.next = heroNode;
    }

    // 3. 显示链表，遍历
    public void showList() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头节点不能动，所以需要辅助变量来遍历
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // 4. 修改节点信息，根据编号来修改
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (temp != null) {
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.println("找不到节点，不能修改");
        }
        return;
    }

    // 5. 删除节点
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表空，删除不了");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (temp.next != null) {
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("要删除的节点不存在");
        }
        return;
    }

}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    // 构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

}