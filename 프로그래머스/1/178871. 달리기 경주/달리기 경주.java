import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rankMap = new HashMap<>();
 
        for (int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }
    
        for (String called : callings) {
            int rank = rankMap.get(called);
            
            String player = players[rank - 1];
            players[rank - 1] = players[rank];
            players[rank] = player;
            
            rankMap.put(players[rank - 1], rank - 1);
            rankMap.put(players[rank], rank);
        }
        
        return players;
    }
}