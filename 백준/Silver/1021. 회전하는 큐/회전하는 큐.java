import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         *
         * 메인 아이디어
         * : [0, 1, 2, 3, 4]
         *          ^  현재 인덱스 기준
         *  (좌측 원소의 개수) = (현재 인덱스)
         *  (우측 원소의 개수) = (리스트 크기) - (현재 인덱스) - 1;
         *  무조건 첫번째 원소를 제거함. 따라서 우측에 남아 있는 원소의 개수가 작은 경우 쉬프트 연산이 한 번 더 필요함.
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[M];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < M; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        LinkedList<Integer> list = new LinkedList<>();

        IntStream.rangeClosed(1, N).forEach(list::addLast);
        int answer = 0;

        for (int i = 0; i < M; i++) {
            int target = nums[i];
            int leftLen = list.indexOf(target);
            int rightLen = list.size() - leftLen - 1;

            if (leftLen <= rightLen) {
                for (int loop = 0; loop < leftLen; loop++) {
                    list.addLast(list.removeFirst());
                    answer++;
                }
            } else {
                for (int loop = 0; loop <= rightLen; loop++) {
                    list.addFirst(list.removeLast());
                    answer++;
                }
            }

            list.removeFirst();
        }

        System.out.println(answer);
        br.close();
    }
}
