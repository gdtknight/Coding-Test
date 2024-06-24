import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        for (int lIdx = 0, rIdx = people.length - 1; lIdx <= rIdx;) {
            answer++;
            
            while(lIdx < rIdx && people[lIdx] + people[rIdx] > limit) {
                answer++;
                rIdx--;
            }
            
            lIdx++;
            rIdx--;
        }
        
        return answer;
    }
}