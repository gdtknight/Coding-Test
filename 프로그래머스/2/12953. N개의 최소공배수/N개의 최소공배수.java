import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.TreeMap;

class Solution {
    static boolean[] prime = new boolean[101];
    
    public int solution(int[] arr) {
        Arrays.sort(arr);
        
        final int MAX = 50;
        
        TreeMap<Integer, Integer> primeCount = new TreeMap<>();
        
        Arrays.fill(prime, true);
        
        prime[0] = false;
        prime[1] = false;
        
        for (int num = 2; num <= MAX; num++) {
            if (!prime[num]) continue;
            
            primeCount.put(num, 0);
            
            for (int idx = num + num; idx <= MAX; idx += num) {
                prime[idx] = false;
            }
        }
        
        System.out.println(primeCount.keySet());
        
        for (int num : arr) {
            for (int prime : primeCount.keySet()) {
                if (prime > num) break;
                
                int count = 0;
                int temp = num;
                
                while (temp % prime == 0) {
                    count++;
                    temp /= prime;
                }
                
                primeCount.put(prime, Math.max(primeCount.get(prime), count));
            }
        }
        
        int answer = 1;
        
        for(Entry<Integer, Integer> e : primeCount.entrySet()) {
            answer *= (int) Math.pow(e.getKey(), e.getValue());
        }
        
        return answer;
    }
}