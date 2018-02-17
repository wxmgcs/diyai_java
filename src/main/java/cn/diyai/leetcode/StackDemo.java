package cn.diyai.leetcode;

import java.util.Stack;

public class StackDemo {
    /**
     * 如果没有遇到运算符就将数字入栈，遇到运算符出栈后再次做运算
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<Integer>();

        if (tokens.length == 0) {
            return 0;
        }

        int result1 = 0;
        int result2 = 0;

        for (String token : tokens) {
            if (token.equals("+")) {
                result1 = stack.pop();
                result2 = stack.pop();
                stack.push(result2 + result1);
            } else if (token.equals("-")) {
                result1 = stack.pop();
                result2 = stack.pop();
                stack.push(result2 - result1);
            } else if (token.equals("*")) {
                result1 = stack.pop();
                result2 = stack.pop();
                stack.push(result2 * result1);
            } else if (token.equals("/")) {
                result1 = stack.pop();
                result2 = stack.pop();
                stack.push(result2 / result1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {

        StackDemo stackDemo = new StackDemo();
        System.out.println(String.format("%s %s = %s", "四则运算", stackDemo.evalRPN(new String[]{}), 0));

        System.out.println(String.format("%s %s = %s", "四则运算", stackDemo.evalRPN(new String[]{"1"}), 1));

        System.out.println(String.format("%s %s = %s", "四则运算", stackDemo.evalRPN(new String[]{"1", "2", "-"}), -1));

        //((2 + 1) * 3)
        System.out.println(String.format("%s %s = %s", "四则运算", stackDemo.evalRPN(new String[]{"2", "1", "+", "3", "*"}), 9));
        //(4 + (13 / 5))
        System.out.println(String.format("%s %s = %s", "四则运算", stackDemo.evalRPN(new String[]{"4", "13", "5", "/", "+"}), 6));


    }
}
