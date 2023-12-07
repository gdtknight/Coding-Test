import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> map = new HashMap<>();
        
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        return Arrays.stream(data).filter(item->item[map.get(ext)] < val_ext).sorted((item1, item2) -> Integer.compare(item1[map.get(sort_by)],item2[map.get(sort_by)])).toArray(int[][]::new);
    }
}


