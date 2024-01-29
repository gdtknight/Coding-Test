import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> suspend = new LinkedList();
        
        for (int idx = 0; idx < priorities.length; idx++) {
            Process current = Process.create(idx, priorities[idx]);
            suspend.offer(current);
        }
        
        int order = 1;
        
        outer:
        while(!suspend.isEmpty()) {
            Process current = suspend.poll();
            
            for (Process process : suspend) {
                if (process.getPriority() > current.getPriority()) {
                    suspend.offer(current);
                    continue outer;
                }
            }
            
            if (current.getIdx() == location) {
                return order;
            }
            
            order++;
        }
        
        return -1;
    }
}

class Process {
    private final int IDX;
    private final int PRIORITY;
    private int executedOrder = Integer.MAX_VALUE;
    
    private Process(final int IDX, final int PRIORITY) {
        this.IDX = IDX;
        this.PRIORITY = PRIORITY;
    }
    
    public static Process create(final int idx, final int priority) {
        return new Process(idx, priority);
    }
    
    public void setExecutedOrder(int order) {
        executedOrder = order;
    }
    
    public int getIdx() {
        return IDX;
    }
    
    public int getPriority() {
        return PRIORITY;
    }
    
    public int getExecutedOrder() {
        return executedOrder;
    }
}