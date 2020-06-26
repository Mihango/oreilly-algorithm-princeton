package labs.khobfa.queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    private static Queue<Integer> reverse(Queue<Integer> queue, int count) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> result = new LinkedList<>();

        for(int i = 0; i < count; i++) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        while (!queue.isEmpty()) {
            result.add(queue.remove());
        }
        return result;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            queue.add(i * 10);
        }
        Queue<Integer> q = reverse(queue, 5);
        while (!q.isEmpty()) {
            System.out.println(q.remove() + ", ");
        }
    }
}
