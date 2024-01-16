import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Friend> map = new HashMap<>();
        
        for (String name : friends) {
            map.put(name, new Friend(name));
        }
        
        String[] names;
        String giver, taker;
        
        for (String record : gifts) {
            names = record.split(" ");
            giver = names[0];
            taker = names[1];
            
            map.get(giver).increaseGiveCount(taker);
            map.get(taker).increaseTakeCount(giver);
        }
        
        for (int i = 0; i < friends.length - 1; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                String a = friends[i];
                String b = friends[j];
                
                if (map.get(a).getGiveCount(b) > map.get(b).getGiveCount(a)) {
                    map.get(a).increaseGiftCount();
                } else if (map.get(a).getGiveCount(b) < map.get(b).getGiveCount(a)) {
                    map.get(b).increaseGiftCount();
                } else {
                    if (map.get(a).getGiftIdx() > map.get(b).getGiftIdx()) {
                        map.get(a).increaseGiftCount();
                    } else if (map.get(a).getGiftIdx() < map.get(b).getGiftIdx()) {
                        map.get(b).increaseGiftCount();
                    }
                }
            }
        }
        
        return map.values().stream()
            .mapToInt(Friend::getGiftCount)
            .max()
            .orElse(0);
    }
}

class Friend {
    private final String name;
    
    private Map<String, Integer> giveCountMap = new HashMap<>();
    private Map<String, Integer> takeCountMap = new HashMap<>();
    
    private int giftCount = 0;
    
    public Friend(String name) {
        this.name = name;
        this.giftCount = 0;
	}
    
    public void increaseGiveCount(String taker) {
        giveCountMap.put(taker, giveCountMap.getOrDefault(taker, 0) + 1);
    }
    
    public int getGiveCount(String to) {
        return giveCountMap.getOrDefault(to, 0);
    }
    
    public int getTakeCount(String from) {
        return takeCountMap.getOrDefault(from, 0);
    }
    
    public void increaseTakeCount(String giver) {
        takeCountMap.put(giver, takeCountMap.getOrDefault(giver, 0) + 1);
    }
    
    public int getGiftIdx() {
        
        int giveCount = giveCountMap.values().stream()
            .mapToInt(Integer::intValue)
            .sum();
        int takeCount = takeCountMap.values().stream()
            .mapToInt(Integer::intValue)
            .sum();
        
        return giveCount - takeCount;
    }
    
    public void increaseGiftCount() {
        this.giftCount++;
    }
    
    public int getGiftCount() {
        return giftCount;
    }
}
