import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            // 10, 100, 1000 등 10의 배수인 경우에는 가장 높은 자리수만큼 버튼을 누르면 된다.
            int mod = storey % 10;
            
            while (mod == 0) {
                storey /= 10;
                mod = storey % 10;
            }
            
            // 1의 자리가 0이 아님.
            
            if (mod > 5) {
                answer += (10 - mod);
                storey += 10;
            } else if (0 < mod && mod < 5) {
                answer += mod;
            } else if (mod == 5) {
                int temp = (storey / 10) % 10;
                
                if (temp < 5) {
                    answer += mod;
                } else {
                    answer += (10 - mod);
                    storey += 10;
                }
            } 
            
            storey /= 10;
        }
        
        return answer;
    }
}