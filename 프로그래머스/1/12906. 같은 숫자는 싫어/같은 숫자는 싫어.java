import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int len = 1;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) continue;
            len++;
        }
        
        int [] newArr = new int[len];
        
        newArr[0] = arr[0];
        
        for (int lIdx = 1, rIdx = 1; lIdx < len && rIdx < arr.length; ) {
            if (arr[rIdx - 1] == arr[rIdx]) rIdx++;
            else newArr[lIdx++] = arr[rIdx++];
        }
        
        return newArr;
    }
}