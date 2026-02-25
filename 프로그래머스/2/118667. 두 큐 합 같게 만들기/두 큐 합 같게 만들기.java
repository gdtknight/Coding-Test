import java.util.Arrays;

class Solution {
    
    // 최대 연산 횟수 + 1 (실패 판단 기준)
    private final int INF = 600_001;

    public int solution(int[] queue1, int[] queue2) {
        // 각 큐의 총합을 long으로 계산하여 오버플로 방지
        long sum1 = Arrays.stream(queue1).asLongStream().sum();
        long sum2 = Arrays.stream(queue2).asLongStream().sum();

        // 목표 합은 두 큐의 총합의 절반
        long half = (sum1 + sum2) / 2;

        // 큐 길이 및 전체 범위 설정
        int len1 = queue1.length;
        int end = len1 * 2;

        // 투포인터 초기화
        int left = 0, right = len1 - 1;
        long sum = sum1;
        int answer = INF;

        // 투포인터 탐색
        while (left <= right) {
            if (sum > half) {
                // 합이 너무 크면 왼쪽 원소를 제거
                if (left < len1) sum -= queue1[left++];
                else sum -= queue2[left++ - len1];
            } else {
                // 합이 목표와 같으면 정답 후보 갱신
                if (sum == half) {
                    answer = Math.min(answer, left + (right - (len1 - 1)));
                }
                // 합이 부족하면 오른쪽에서 원소를 추가
                if (right + 1 < end) sum += queue2[++right - len1];
                else break;  // 더 이상 추가 불가 시 종료
            }
        }

        // 정답 반환 (최소 연산 횟수 or 불가능 시 -1)
        return answer == INF ? -1 : answer;
    }
}