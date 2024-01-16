import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> expMap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        String[] dateArr = today.split("\\.");
        long startDay = 
            Integer.parseInt(dateArr[0]) * 12 * 28 + 
            Integer.parseInt(dateArr[1]) * 28 + 
            Integer.parseInt(dateArr[2]);
        
        for (String term : terms) {
            String[] args = term.split(" ");
            expMap.put(args[0], Integer.parseInt(args[1]) * 28);
        }
        
        for (int idx = 0; idx < privacies.length; idx++) {
            String[] args = privacies[idx].split(" ");
            String privacyType = args[1];
            
            String[] dates = args[0].split("\\.");
            
            long endDay =
                Integer.parseInt(dates[0]) * 12 * 28 + 
                Integer.parseInt(dates[1]) * 28 + 
                Integer.parseInt(dates[2])
                + expMap.get(privacyType);
            
            if (startDay >= endDay) list.add(idx + 1);
        }
        
        
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}