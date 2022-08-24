package Base;

import Tool.StdIn;

public class TestFixedCapacityStack {
    public static void main(String[] args) {
        FixedCapacityStack<String> s;
        s = new FixedCapacityStack<String>(100);
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-"))
                s.push(item);
            else if(!s.isEmpty())
                System.out.print(s.pop()+" ");
        }
        System.out.println("("+s.size()+" left on stack)");
    }
}
