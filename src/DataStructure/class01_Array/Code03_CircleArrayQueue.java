package DataStructure.class01_Array;

import java.util.Scanner;

public class Code03_CircleArrayQueue {
    public static void main(String[] args) {
        CircleArray circleArray = new CircleArray(4); // 有效数据是3，因为空出来了一个
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出队列");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头数据");
            System.out.println();
            key = scanner.next().charAt(0); // 接收一个字符
            switch (key) {
                case 's':
                    circleArray.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    circleArray.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = circleArray.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleArray.headQueue();
                        System.out.printf("队列头是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.printf("程序退出");

    }
}
class CircleArray {
    private int maxSize;
    private int front; // 队头【包含】
    private int rear;  // 队尾【不含，队尾的后一个位置，空出最后一个位置】
    private int[] arr; // 存放数据、模拟队列
    public CircleArray (int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }
    // 判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }
    // 判断队列是否空
    public boolean isEmpty() {
        return rear == front;
    }
    // 添加数据到队列
    public void addQueue(int n){
        if (isFull()) {
            System.out.println("队列满，不能加");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }
    // 获取队列数据
    public int getQueue(){
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }
    // 显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空，没有数据");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("%d\t", arr[i % maxSize]);
        }
    }
    // 当前队列有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
    // 显示队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有头数据");
        }
        return arr[front];
    }
}
