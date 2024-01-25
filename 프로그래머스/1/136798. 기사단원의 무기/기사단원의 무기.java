import java.util.Arrays;

class Solution {
    public int solution(int number, int limit, int power) {
        int[] countArr = new int[number + 1];
        
        for (int idx = 1; idx <= number; idx++) {
            for (int j = idx; j <= number; j += idx) {
                countArr[j]++;
            }
        }
        
        return Arrays.stream(countArr)
            .map(cnt -> cnt > limit ? power : cnt)
            .reduce((n1, n2) -> n1 + n2)
            .orElse(0);
    }
}