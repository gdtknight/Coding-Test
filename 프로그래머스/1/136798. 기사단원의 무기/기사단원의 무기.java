import java.util.Arrays;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        /**
        *
        * 메인 아이디어
        * : 어떤 숫자 n의 약수가 x라면 n은 x의 배수
        *   즉, n이 x의 배수라면 n의 약수의 개수를 하나씩 추가한다.
        *
        **/
        
        // 1부터 number 까지의 약수의 개수를 저장
        int[] countDiv = new int[number + 1];
        
        // n 은 1부터 number 까지
        for (int n = 1; n <= number; n++) {
            // x 는 n 의 모든 배수
            for (int x = n; x <= number; x += n) {
                countDiv[x]++;
            }
            
            if (countDiv[n] > limit) {
                countDiv[n] = power;
            }
            
            answer += countDiv[n];
        }
        
        // 약수의 개수, 즉, 공격력이 power 를 초과할 경우 power 로 변환
        return answer;
    }
}