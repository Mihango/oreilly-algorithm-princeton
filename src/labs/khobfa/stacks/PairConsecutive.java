package labs.khobfa.stacks;

import java.util.Stack;

public class PairConsecutive {

    public static boolean check(Stack<Integer> data) {
        boolean isPair = true;

        if(data.isEmpty() || data.size() % 2 != 0)
            return false;

        while(!data.isEmpty()) {
            int i = data.pop();
            int j = data.pop();

            if(j != i-1 || j != i+1 || i != j-1 || i != j+1) {
                isPair = false;
                break;
            }
        }

        return isPair;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(4);
        stack.add(5);
        stack.add(-2);
        stack.add(-3);
        stack.add(11);
        stack.add(10);
        stack.add(5);
        stack.add(6);
//        stack.add(20);
        System.out.println(check(stack));
    }
}
