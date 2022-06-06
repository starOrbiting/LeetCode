package DataStructure.class02_LinkedList;

public class Code02_DoubleLinkedList {
    public static void main(String[] args) {
        // 创建
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(5, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(8, "林冲", "豹子头");
        // 添加
//        doubleLinkedList.add(hero1);
//        doubleLinkedList.add(hero2);
//        doubleLinkedList.add(hero3);
//        doubleLinkedList.add(hero4);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.showList();
        // 修改
        HeroNode2 hero10 = new HeroNode2(8, "haha", "豹子头");
        doubleLinkedList.update(hero10);
        doubleLinkedList.showList();
        // 删除
        doubleLinkedList.delete(8);
        doubleLinkedList.showList();


    }

}
class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");
    public HeroNode2 getHead(){
        return head;
    }
    // 1. 显示链表
    public void showList() {
        System.out.println("------------------------------");
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头节点不能动，所以需要辅助变量来遍历
        HeroNode2 temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
    // 2. 队尾添加
    public  void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
        // 加前指pre
        heroNode.pre = temp;
    }
    // 2. 按顺序添加节点
    public void addByOrder(HeroNode2 heroNode) {
        HeroNode2 temp = head;
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
        heroNode.pre = temp;
        temp.next = heroNode;
        if (temp.next != null){
            temp.next.pre = heroNode;
        }



    }

    // 3. 修改节点信息，和单链表一样
    public void update(HeroNode2 newHeroNode) {
        if (head.next == null) {
            System.out.println("链表空");
            return;
        }
        HeroNode2 temp = head.next;
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
    // 4. 删除节点
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表空，删除不了");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (temp != null) {
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            // 删除的是最后一个节点时，要判断
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("要删除的节点不存在");
        }
        return;
    }


}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    // 构造器
    public HeroNode2(int no, String name, String nickname) {
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