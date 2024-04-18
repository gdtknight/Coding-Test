import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Objects;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        final int HEIGHT = park.length;
        final int WIDTH = park[0].length();
        
        // 초기 위치에 로봇 세팅
        RobotPuppy robotPuppy = null;
        
        outer :
        for (int h = 0; h < HEIGHT; h++) {
            for (int w = 0; w < WIDTH; w++) {
                if (park[h].charAt(w) == 'S') {
                    robotPuppy = new RobotPuppy(h, w);
                    break outer;
                }
            }
        }
        
        
        execute :
        for (String route : routes) {
            String[] tokens = route.split(" ");
            
            Dir dir = Dir.valueOf(tokens[0]);
            int count = Integer.parseInt(tokens[1]);
            
            int nextH = robotPuppy.H;
            int nextW = robotPuppy.W;
            
            for (int i = 0; i < count; i++) {
                nextH += dir.h;
                nextW += dir.w;
                
            	if (nextH < 0 
            	    || nextW < 0 
                	|| HEIGHT <= nextH
                	|| WIDTH <= nextW
                    || park[nextH].charAt(nextW) == 'X')
                    continue execute;
			}
            
            robotPuppy.H = nextH;
            robotPuppy.W = nextW;
        }
        
        return new int[]{ robotPuppy.H, robotPuppy.W };
    }
}

class RobotPuppy {
    int H;
    int W;
    
    public RobotPuppy(int H, int W) {
        this.H = H;
        this.W = W;
    }
}

enum Dir {
    E( 0,  1),
    W( 0, -1),
    S( 1,  0),
    N(-1,  0);
    
    final int h;
    final int w;
    
    Dir(int h, int w) {
        this.h = h;
        this.w = w;
    }
}
