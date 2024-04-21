import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // BufferedReader br = Initialization.getBufferedReaderFromClass(this);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Initialization
        final int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack<Long> stack = new Stack<>();

        for (int idx = 0; idx < N; idx++) {
            stack.push(Long.parseLong(st.nextToken()));
        }
  
        stack.push(1L);

        while (2 < stack.size()) {
            long numerator = stack.pop();
            long denominator = stack.pop();
            long num = stack.pop();

            long nextDenominator = num * denominator + numerator;

            stack.push(nextDenominator);
            stack.push(denominator);
        }

        long lastNumerator = stack.pop();
        long lastDenominator = stack.pop();

        lastNumerator = lastDenominator - lastNumerator;
        System.out.println(lastNumerator + " " + lastDenominator);

        // Your Code

        br.close();
    }
}
