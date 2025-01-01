import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) throws Exception {
      
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
    // Your code
    PriorityQueue<Long> pq = new PriorityQueue<>((i1, i2) -> i1.compareTo(i2));

    int N = Integer.parseInt(br.readLine());
      
    for (int i = 0; i < N; i++) {
      pq.offer(Long.parseLong(br.readLine()));
    }

    long result = 0;
    while (pq.size() > 1) {
      long deck1 = pq.poll();
      long deck2 = pq.poll();
      result += (deck1 + deck2);
      pq.offer(deck1 + deck2);
    }

    System.out.println(result);

    br.close();
  }

}