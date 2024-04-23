import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] minuses = br.readLine().split("-");

        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < minuses.length; i++) {
            int curSum = 0;
            String[] pluses = minuses[i].split("\\+");
            
            for (int j = 0; j < pluses.length; j++) {
                curSum += Integer.parseInt(pluses[j]);
                
            }
            
            list.add(curSum);
        }
                
        int answer = list.get(0);
        for (int i=1; i< list.size(); i++) {
            answer -= list.get(i);
        }
        
        System.out.println(answer);
    }
}