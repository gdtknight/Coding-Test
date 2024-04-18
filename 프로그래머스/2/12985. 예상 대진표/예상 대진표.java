class Solution {
   public int solution(int n, int a, int b) {
       
       /**
       * 
       * 문제에 특별히 제한사항이 없으므로
       * 항상 a < b 를 만족하도록 코드를 추가해준다.
       *
       **/ 
       if (a > b) {
           int temp = a;
           a = b;
           b = temp;
       }
       
       int answer = 0;
       
       while (a != b) {
           a = (a % 2) + (a / 2);
           b = (b % 2) + (b / 2);
           answer++;
       }
       
       return answer;
   }
}