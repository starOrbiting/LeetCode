package DataStructure.class03_Stack;

/**
 * 特别：注意多位数
 * 【优先计算*符号栈内部*级别高的或同级别的，】
 * ex1：符号栈内部【-（3*2）优先】 / 7 => 【- 6/7】
 * ex2：【- 3*2】 + 8 =>【- 6+8】
 * ex2：【-】 * =>【- *】
 * 当前运算符优先级高，直接入栈；<= pop符号和数字先计算，结果push数栈，再push当前运算符
 */

public class Code03_Calculator {
    // 1. 返回运算符优先级
    public static int priority(int oper) {
        // 假设只有+ - * /
        if (oper == '*' || oper == '/'){
            return 1;
        }
        else if (oper == '+' || oper == '-'){
            return 0;
        }
        else {
            return -1;
        }
    }
    // 2. 判断是否运算符
    public static boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }
    // 3. 计算方法
    public static int cal(int num1, int num2, int oper){
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
    public static void main(String[] args) {
        String exp = "30+10";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0, num1 = 0, num2 = 0, res = 0, oper = 0;
        char ch = ' ';
        String temp = "";
        while (index < exp.length()) {
            ch = exp.charAt(index);
            // 1）是运算符
            if (isOper(ch)) {
                if (operStack.isEmpty()){
                    operStack.push(ch);
                    System.out.println("=================");
                }
                else {
                    // 2）和栈顶符号比较优先级
                    // 当前操作符优先级高，直接入栈
                    if (priority(ch) > priority(operStack.peek())) {
                        operStack.push(ch);
                    }
                    // 当前操作符优先级<=；出栈顶符号，出数栈2个数字，先进行运算；将结果入数栈；当前符号入栈；
                    else {
                        oper = operStack.pop();
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        numStack.push(cal(num1, num2, oper));
                        operStack.push(ch);
                    }
                }
            }
            // 3）是数字,直接入数栈【注意多位数】
            else {
                temp = "";
                while (!isOper(ch)){
                    temp += ch;
                    index++;
                    if (index >= exp.length()){
                        break;
                    }
                    ch = exp.charAt(index);
                }
                System.out.println(temp);

                // ch是char类型 '1'和1差48，要转换一下
                numStack.push(Integer.parseInt(temp));
            }
            index++;
        }
        // 4）符号栈为空时，数栈只剩最后一个值（结果）；不为空时，pop2个数和1个符号进行运算，结果压栈，再判断4）。【符号栈：+ * 】
        while (!operStack.isEmpty()){
            System.out.println("--------------");
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            System.out.println(num1);
            System.out.println(num2);
            numStack.push(cal(num1, num2, oper));
        }
        // 5）最后数栈只剩一个数（结果）
        System.out.printf("表达式%s = %d\n", exp, numStack.pop());




    }
}
class ArrayStack2 {
    private int maxSize; // 栈的大小
    private int[] stack;
    private int top = -1; // 索引
    public ArrayStack2(int maxSize) {
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
    // 显示栈顶元素
    public int peek() {
        if (isEmpty()){
            throw new RuntimeException("栈空，无栈顶元素");
        }
        return stack[top];
    }

}

