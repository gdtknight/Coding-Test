import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int[] temp = new int[rocks.length + 1];
        Arrays.sort(rocks);
        System.arraycopy(rocks, 0, temp, 0, rocks.length);
        temp[rocks.length] = distance;
        rocks = temp;
        
        int min = 0, max = distance;
        
        while(min <= max) {
            int mid = min + (max - min) / 2;
            
            int curPos = 0;
            int countRock = 0;
            
            for (int rock : rocks) {
                if (rock - curPos < mid) {
                    countRock++; 
                } else {
                    curPos = rock;
                }
            }
            
            if (countRock <= n) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        
        return min - 1;
    }
}