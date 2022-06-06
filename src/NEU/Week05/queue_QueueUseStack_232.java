package NEU.Week05;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class queue_QueueUseStack_232 {
    class MyQueue {
        // 思路1：两个栈互相倒
        public Stack<Integer> inStack;
        public Stack<Integer> outStack;

        public MyQueue() {
            inStack = new Stack<Integer>();
            outStack = new Stack<Integer>();
        }

        public void push(int x) {
           inStack.push(x);
        }

        public int pop() {
           if (outStack.isEmpty()){
               in2out();
           }
           return outStack.pop();
        }

        public int peek() {
            if (outStack.isEmpty()){
                in2out();
            }
            return outStack.peek();

        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        public void in2out(){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }

        // 思路2：数组模拟
//        public int[] queue;
//        public int front, rear;
//        public MyQueue() {
//            queue = new int[100];
//            front = -1;
//            rear = 0;
//        }
//
//        public void push(int x) {
//            queue[front++] = x;
//            rear++;
//        }
//
//        public int pop() {
//            int val = queue[front];
//            front++;
//            return val;
//        }
//
//        public int peek() {
//            return queue[front];
//
//        }
//
//        public boolean empty() {
//            return front == rear;
//        }
    }
}
