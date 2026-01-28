import java.util.HashMap;

class Solution {
    public int[] solution(String[] names, int[] yearnings, String[][] photos) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int idx = 0; idx < names.length; idx++) {
            map.put(names[idx], yearnings[idx]);
        }
        
        int[] answer = new int[photos.length];
        
        for (int idx = 0; idx < photos.length; idx++) {
            for (String name: photos[idx]) {
                if (map.containsKey(name))
            		answer[idx] += map.get(name);
            }
        }
        
        return answer;
    }
}