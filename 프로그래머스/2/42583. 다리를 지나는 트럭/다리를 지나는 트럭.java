import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(
        final int BRIDGE_LENGTH,
        final int MAX_WEIGHT,
        final int[] WEIGHTS
    ) {
        
        int currentTime = 1;
        int currentWeight = 0;
        
        int idx = 0;
        
        int weight = Integer.MAX_VALUE;
        
        Truck truck = null;
        
        Queue<Truck> bridge = new LinkedList<>();
        
        while (idx < WEIGHTS.length) {
            // 다리를 건너는 트럭이 없으면 바로 건너면 됨.
            if (bridge.isEmpty()) {
                bridge.offer(new Truck(WEIGHTS[idx], currentTime));
                currentWeight += WEIGHTS[idx];
                currentTime++;
                idx++;
                continue;
            }
            
            // 다리 위에 트럭이 있는 경우 
            
            // 도착한 트럭
            if (bridge.peek().getEntryTime() + BRIDGE_LENGTH == currentTime) {
                truck = bridge.poll();
                currentWeight -= truck.getWeight();
            }
                
            
            // 다리를 건널 수 있는 경우
            if (currentWeight + WEIGHTS[idx] <= MAX_WEIGHT) {
                bridge.offer(new Truck(WEIGHTS[idx], currentTime));
                currentWeight += WEIGHTS[idx];
                currentTime++;
                idx++;
            }
            
            // 다리를 건널 수 없는 경우 앞선 트럭이 다리를 건널 때까지 시간을 흘려보냄.
            else {
                currentTime++;
            }
        }
        
        // 모든 트럭이 다리를 건널 때까지 시간 계산
        while (!bridge.isEmpty()) {
            if (bridge.peek().getEntryTime() + BRIDGE_LENGTH == currentTime) {
                truck = bridge.poll();
                currentWeight -= truck.getWeight();
            }
            currentTime++;
        }
        
        return currentTime - 1;
    }
}

class Truck {
    final int WEIGHT;
    final int ENTRY_TIME;
    
    public Truck(final int WEIGHT, final int ENTRY_TIME) {
        this.WEIGHT = WEIGHT;
        this.ENTRY_TIME = ENTRY_TIME;
    }
    
    public int getWeight() {
        return WEIGHT;
    }
    
    public int getEntryTime() {
        return ENTRY_TIME;
    }
    
    public String toString() {
        return "{w:" + WEIGHT + ",t:" + ENTRY_TIME + "}";
    }
}
