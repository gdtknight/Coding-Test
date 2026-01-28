/*
 * 현재 상자 번호 바로 위 상자의 번호
 * 
 *  next = (w * ((num - 1) / w + 1) + 1) + (w - (num - 1) % w) - 1;
 */
class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int next = (w * ((num - 1) / w + 1) + 1) + (w - (num - 1) % w) - 1;
        while (next <= n) {
            System.out.println("num : " + num + ", next : " + next);
            answer++;
            num = next;
            next = w * ((num - 1) / w + 1) + (w - (num - 1) % w);
        }
        
        return (answer + 1);
    }
}