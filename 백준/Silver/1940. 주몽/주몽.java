import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    int[] ingredients = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      ingredients[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(ingredients);

    int left = 0;
    int right = ingredients.length - 1;

    int count = 0;
    while (left < right) {
      if (ingredients[left] + ingredients[right] == M) {
        left++;
        right--;
        count++;
      } else if (ingredients[left] + ingredients[right] > M) {
        right--;
      } else if (ingredients[left] + ingredients[right] < M) {
        left++;
      }
    }

    if (left == right && ingredients[left] == M) count++;

    System.out.println(count);
  }
}
