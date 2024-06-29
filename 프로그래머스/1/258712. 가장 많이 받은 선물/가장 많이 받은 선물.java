import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> map = new HashMap<>();
        
        int[][] count = new int[friends.length][friends.length];
        int[] giftCount = new int[friends.length];
        
        for (int idx = 0; idx < friends.length; idx++) {
            map.put(friends[idx], idx);
        }
        
        String[] names;
        String giver, taker;
        
        for (String record : gifts) {
            String[] args = record.split(" ");
            
            count[map.get(args[0])][map.get(args[1])]++;
        }
        
        for (int a = 0; a < friends.length - 1; a++) {
            for (int b = a + 1; b < friends.length; b++) {
                
                if (count[a][b] > count[b][a]) giftCount[a]++;
                else if (count[a][b] < count[b][a]) giftCount[b]++;
                else {
                    int giftIdxA = 0, giftIdxB = 0;
                    
                    for (int idx = 0; idx < friends.length; idx++) {
                        giftIdxA += (count[a][idx] - count[idx][a]);
                        giftIdxB += (count[b][idx] - count[idx][b]);
                    }
                    
                    if (giftIdxA > giftIdxB) giftCount[a]++;
                    else if (giftIdxA < giftIdxB) giftCount[b]++;
                }
            }
        }
        
        return Arrays.stream(giftCount)
            .max()
            .orElse(0);
    }
}
