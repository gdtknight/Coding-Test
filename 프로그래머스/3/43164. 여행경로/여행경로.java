import java.lang.Comparable;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

class Solution {
    
    public String[] solution(String[][] tickets) {
        final String START = "ICN";
        final int MAX_COUNT = tickets.length;
        
        final Stack<String> answer = new Stack<>();
        final Map<String, PriorityQueue<Ticket>> ticketMap = new HashMap<>();
        final Set<Ticket> usedTickets = new HashSet<>();
        
        for (String[] ticket : tickets) {
            String depature = ticket[0];
            String arrival = ticket[1];
            
            Ticket newTicket = new Ticket(depature, arrival);
            
            PriorityQueue<Ticket> arrivals = ticketMap.getOrDefault(depature, new PriorityQueue<Ticket>());
            
            arrivals.offer(newTicket);
            
            ticketMap.put(depature, arrivals);
        }
        
        Stack<Ticket> stack = new Stack<>();
        stack.push(ticketMap.get(START).peek());
        usedTickets.add(ticketMap.get(START).peek());
        
        out :
        while(!stack.isEmpty()) {
            Ticket current = stack.peek();
            
            Iterator<Ticket> it = ticketMap.getOrDefault(current, new PriorityQueue<Ticket>()).iterator();
            
            while(it.hasNext()) {
                Ticket next = it.next();
                if (usedTickets.add(next)) {
                    stack.push(next);
                    continue out;
                }
            }
            
            answer.push(current.arrival());
            stack.pop();
        }
        
        answer.push(START);
        
        return answer.stream().toArray(String[]::new);
    }
}
    

class Ticket implements Comparable<Ticket> {
    String depature;
    String arrival;
    
    Ticket (String depature, String arrival) {
        this.depature = depature;
        this.arrival = arrival;
    }
    
    public String depature() {
        return depature;
    }
    
    public String arrival() {
        return arrival;
    }
    
    public int compareTo(Ticket t) {
        return depature.equals(t.depature())
            ? arrival.compareTo(t.arrival())
            : depature.compareTo(t.depature());
    }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        
        if (!(o instanceof Ticket)) return false;
        
        Ticket t = (Ticket) o;
        
        return depature.equals(t.depature()) && arrival.equals(t.arrival());
    }
    
    public int hashCode() {
        return depature.hashCode() * 31 + arrival.hashCode();
    }
    
    public String toString() {
        return "[" + depature + ", " + arrival + "]";
    }
}