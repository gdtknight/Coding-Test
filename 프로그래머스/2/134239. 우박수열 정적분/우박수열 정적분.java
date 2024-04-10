import java.util.List;
import java.util.ArrayList;

class Solution {
    static List<Integer> collatz = new ArrayList<>();
    
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        addCollatzNumbers(k);
        
        final int N = collatz.size() - 1;
        
        for (int idx = 0; idx < ranges.length; idx++) {
            double sum = 0;
            // System.out.println("[" + ranges[idx][0] + ", " + (N + ranges[idx][1]) +"]");
                
            if (ranges[idx][0] > N + ranges[idx][1]) {
                answer[idx] = -1; 
            } else if (ranges[idx][0] == N + ranges[idx][1]) {
                answer[idx] = 0;
            } else {
                for (int pos = ranges[idx][0]; pos < N + ranges[idx][1]; pos++) {
                    sum += ((double) collatz.get(pos) + (double) collatz.get(pos + 1)) / 2.0;
                }
                answer[idx] = sum;
            }
        }
        
        return answer;
    }
    
    private void addCollatzNumbers(int k) {
        collatz.add(k);
        
        while (k > 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            
            collatz.add(k);
        }
    }
}