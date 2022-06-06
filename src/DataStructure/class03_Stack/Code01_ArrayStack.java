package DataStructure.class03_Stack;

import java.util.Scanner;

/**
 * 数组模拟栈
 */
public class Code01_ArrayStack {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
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
class ArrayStack {
    private int maxSize; // 栈的大小
    private int[] stack;
    private int top = -1; // 索引
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }
    // 判断是否满
    public boolean isFull() {
        // top[0~maxSize-1]
        return top >= maxSize - 1;
    }
    // 判断是否空
    public boolean isEmpty() {
        return top == -1;
    }
    // 入栈
    public void push(int value) {
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
        return;
    }
    // 出栈
    public int pop() {
        if (isEmpty()) {
            // 抛出异常处理
            throw new RuntimeException("栈空，无数据");
        }
        int value = stack[top];
        top--;
        return value;
    }
    // 显示栈（倒序遍历），从栈顶开始显示
    public void showStack() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }

    }


}










