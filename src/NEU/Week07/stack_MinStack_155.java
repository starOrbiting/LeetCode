package NEU.Week07;

import java.util.Deque;
import java.util.LinkedList;


public class stack_MinStack_155 {

}
class MinStack{
    // 思路：辅助栈与元素栈同步插入与删除，用于存储与每个元素对应的最小值。
    Deque<Integer> mStack;
    Deque<Integer> stack;

    public MinStack() {
        mStack = new LinkedList<Integer>();
        stack = new LinkedList<Integer>();
        mStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        mStack.push(Math.min(val, mStack.peek()));
        stack.push(val);
    }

    public void pop() {
        stack.pop();
        mStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        int val = mStack.peek();
        return val;
    }
}
