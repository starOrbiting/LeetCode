package DataStructure.class03_Stack;

import java.util.Scanner;

/**
 * 队列模拟栈
 */
public class Code02_LinkedListStack {
    public static void main(String[] args) {
//        FirstStack stack = new FirstStack(4);
        HeadStack stack = new HeadStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("show:显示栈");
        System.out.println("exit:退出");
        System.out.println("push:入栈");
        System.out.println("pop:出栈");
        System.out.println("请输入操作----------");
        while (loop) {

            key = scanner.next();
            switch (key){
                case "show":
                    stack.showStack();
                    break;
                case "push":
                    System.out.println("请输入一个数----");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;

                case "pop":
                    // 有可能抛出异常
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈数据是%d\n", res);
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}

/**
 * FirstStack 不带head头节点
 * 在入栈第一个节点【first = new Node】、只有一个节点时进行出栈【first = null】，都需要单独判断一下
 */
class FirstStack{
    // 1. 无头结点
    public Node first = null;
    public int maxSize;
    public FirstStack(int maxSize){
        this.maxSize = maxSize;
    }

    public boolean isFull(){
        Node temp = first;
        int len = 0;
        while (temp != null){
            len++;
            temp = temp.next;
        }
        return len >= maxSize;
    }

    public boolean isEmpty(){
        return first == null;
    }

    // s.showStack()
    public void showStack(){
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        Node n_first = new Node(first.no);
        Node cur = first.next;
        while (cur != null){
            Node n_cur = new Node(cur.no);
            n_cur.next = n_first;
            n_first = n_cur;
            cur = cur.next;
        }
        // 结束循环，n_first是新链表的第一个节点
        cur = n_first;
        while(cur != null){
            System.out.printf("%d\t", cur.no);
            cur = cur.next;
        }
        System.out.println();
    }

    public void push(int data){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        if (isEmpty()){
            first = new Node(data);
            return;
        }
        Node cur = first;
        while (cur.next != null){
            cur = cur.next;
        }
        Node n_node = new Node(data);
        cur.next = n_node;
        return;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        if (first.next == null){
            int value = first.no;
            first = null;
            return value;
        }
        Node cur = first;
        while (cur.next.next != null){
            cur = cur.next;
        }
        int value = cur.next.no;
        cur.next = null;
        return value;
    }

}

/**
 * 带头节点 在pop时可少判断【只有一个节点的情况】
 */
class HeadStack{
    // 2. 带头结点
    public Node head = new Node(0);
    public int maxSize;
    public HeadStack(int maxSize){
        this.maxSize = maxSize;
    }

    public boolean isFull(){
        Node cur = head.next;
        int len = 0;
        while (cur != null){
            len ++;
            cur = cur.next;
        }
        return len >= maxSize;
    }
    public boolean isEmpty(){
        return head.next == null;
    }
    public void showStack(){
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        Node n_head = new Node(0);
        Node cur = head.next;
        while (cur != null){
            Node n_cur = new Node(cur.no);
            n_cur.next = n_head.next;
            n_head.next = n_cur;
            cur = cur.next;
        }
        cur = n_head.next;
        while (cur != null){
            System.out.printf("%d\t", cur.no);
            cur = cur.next;
        }
        System.out.println();
        return;
    }
    public void push(int data){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        Node cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        Node temp = new Node(data);
        cur.next = temp;
        return;
    }
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        Node cur = head;
        while (cur.next.next != null){
            cur = cur.next;
        }
        int value = cur.next.no;
        cur.next = null;
        return value;
    }

}
class Node{
    public int no;
    public Node next;
    public Node(int no){
        this.no = no;
    }
}
