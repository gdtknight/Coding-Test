import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (i1,i2) -> 
            Integer.compare(Math.abs(i1),Math.abs(i2)) == 0
            ? Integer.compare(i1,i2)
            : Integer.compare(Math.abs(i1),Math.abs(i2)) 
        );
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                num = pq.isEmpty() ? 0 : pq.poll();
                System.out.println(num);
            } else {
                pq.offer(num);
            }
        }
    }
}