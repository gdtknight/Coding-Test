import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] solution(String[] operations) {
        Deque<Integer> deque = new LinkedList<>();
        
        int[] answer = {};
        
        for (String operation : operations) {
            String[] args = operation.split(" ");
            
            String op = args[0];
            int arg = Integer.parseInt(args[1]);
            
            if ("I".equals(op)) {
                if (deque.isEmpty()) deque.offer(arg);
                else if (arg <= deque.peekFirst()) deque.offerFirst(arg);
                else if (arg >= deque.peekLast()) deque.offerLast(arg);
            } else if ("D".equals(op)) {
                if (arg == -1 && !deque.isEmpty()) deque.pollFirst();
                else if (arg == 1 && !deque.isEmpty()) deque.pollLast();
            }
        }
        
        return deque.isEmpty()
            ? new int[]{0, 0}
            : new int[]{deque.peekLast(), deque.peekFirst()};
    }
}

