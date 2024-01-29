import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(
        final int BRIDGE_LENGTH,
        final int MAX_WEIGHT,
        final int[] WEIGHTS
    ) {
        Queue<Truck> bridge = new LinkedList<>();
        
        int currentTime = 0;
        int currentWeight = 0;
        
        boolean flag = true;
        for (int weight : WEIGHTS) {
            while (currentWeight + weight > MAX_WEIGHT) {
                if (bridge.peek().getEntryTime() + BRIDGE_LENGTH >= currentTime++) {
                    Truck truck = bridge.poll();
                    currentWeight -= truck.getWeight();
                    flag = false;
                }
            }
            
            if (flag) {
                currentTime++;
            } else {
                flag = true;
            }
            
            bridge.offer(Truck.create(weight, currentTime));
            currentWeight += weight;
        }
        
        
        return currentTime + BRIDGE_LENGTH;
    }
}

class Truck {
    final int WEIGHT;
    final int ENTRY_TIME;
    
    private Truck(final int WEIGHT, final int ENTRY_TIME) {
        this.WEIGHT = WEIGHT;
        this.ENTRY_TIME = ENTRY_TIME;
    }
    
    public static Truck create(final int WEIGHT, final int ENTRY_TIME) {
        return new Truck(WEIGHT, ENTRY_TIME);
    }
    
    public int getWeight() {
        return WEIGHT;
    }
    
    public int getEntryTime() {
        return ENTRY_TIME;
    }
}