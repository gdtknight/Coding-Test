import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> sub = new Stack<>();
        int answer = 0;
        int box = 1;                  // 컨베이어에서 다음에 올 상자 번호

        for (int target : order) {
            // target 이상이 될 때까지 컨베이어에서 보조 벨트로 이동
            while (box <= order.length
                   && (sub.isEmpty() || sub.peek() != target)) {
                sub.push(box++);
            }

            // 보조 벨트의 top이 target인지 확인
            if (!sub.isEmpty() && sub.peek() == target) {
                sub.pop();
                answer++;
            } else {
                // 더 이상 순서를 맞출 수 없음
                break;
            }
        }

        return answer;
    }
}
