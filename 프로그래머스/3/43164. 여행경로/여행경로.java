import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Comparator;

class Solution {
    public String[] solution(String[][] tickets) {
        final String START = "ICN";
        final Map<String, PriorityQueue<String>> ticketMap = new HashMap<>();
        final List<String> answer = new ArrayList<>();
        
        for (String[] ticket : tickets) {
            String depature = ticket[0];
            String arrival = ticket[1];
            
            PriorityQueue<String> arrivals = ticketMap.getOrDefault(depature, new PriorityQueue<String>());
            
            arrivals.offer(arrival);
            
            ticketMap.put(depature, arrivals);
        }
        
        Stack<String> stack = new Stack<>();
        
        stack.push(START);
        
        while(!stack.isEmpty()) {
            String depature = stack.peek();
            PriorityQueue<String> pq = ticketMap.get(depature);
            
            if (pq != null && !pq.isEmpty()) {
                stack.push(pq.poll());
            } else {
                answer.add(stack.pop());
            }
        }
        
        Collections.reverse(answer);
        
        return answer.stream().toArray(String[]::new);
    }
}
