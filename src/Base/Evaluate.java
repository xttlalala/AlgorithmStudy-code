package Base;

import Tool.StdIn;
import java.util.Stack;
//双栈算术表达式求值算法
public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        while(!StdIn.isEmpty()){
            //读取字符
            String s = StdIn.readString();
            //如果是运算符则压入运算符栈
            if(s.equals("("))
                ;//如果遇到“(”,则忽略
            else if(s.equals("+"))
                ops.push(s);
            else if(s.equals("-"))
                ops.push(s);
            else if(s.equals("*"))
                ops.push(s);
            else if(s.equals("/"))
                ops.push(s);
            else if(s.equals("sqrt"))
                ops.push(s);
            else if(s.equals(")")){
                //如果字符为“）”，弹出运算符和操作数，计算结果并压入栈
                String op = ops.pop();
                double v = vals.pop();
                if(op.equals("+"))
                    v = vals.pop() + v;
                else if(op.equals("-"))
                    v = vals.pop() - v;
                else if(op.equals("*"))
                    v = vals.pop() * v;
                else if(op.equals("/"))
                    v = vals.pop() / v;
                else if(op.equals("sqrt"))
                    v = Math.sqrt(v);
                vals.push(v);
            }
            //如果不是运算符和括号，则压入操作数栈
            else vals.push(Double.parseDouble(s));
        }
        System.out.println(vals.pop());
    }
}
