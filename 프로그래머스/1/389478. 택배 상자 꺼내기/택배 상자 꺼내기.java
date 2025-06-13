/*
 현재 상자 번호 바로 위 상자의 번호
 
 next_num = (w * (cur_num / w) + 1) + (w - (cur_num - 1) % w) - 1
 
*/
class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int next_num = (w * ((num - 1) / w + 1) + 1) + (w - (num - 1) % w) - 1;
            
        while (next_num <= n) {
            System.out.println("num : " + num + ", next_num : " + next_num);
            answer++;
            num = next_num;
            next_num = (w * ((num - 1) / w + 1) + 1) + (w - (num - 1) % w) - 1;
        }
        
        return (answer + 1);
    }
}