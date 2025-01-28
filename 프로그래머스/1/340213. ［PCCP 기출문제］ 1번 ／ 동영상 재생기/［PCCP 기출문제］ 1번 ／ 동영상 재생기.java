class Solution {
    public String solution (
        		String video_len,
        		String pos,
        		String op_start,
        		String op_end,
        		String[] commands
    ) {
        int cur_second = convertToSecond(pos);
        int vlen = convertToSecond(video_len);
        int op_start_second = convertToSecond(op_start);
        int op_end_second = convertToSecond(op_end);
        
        for (String command : commands) {
            if (op_start_second <= cur_second && cur_second <= op_end_second)
                cur_second = op_end_second;
            if ("prev".equals(command)) {
                if (cur_second - 10 > 0)
                    cur_second -= 10;
                else
                    cur_second = 0;
            } else {
                if (cur_second + 10 > vlen)
                    cur_second = vlen;
                else
                    cur_second += 10;
            }
            // System.out.println("Current Pos : " + convertToString(cur_second));
        }
        
        if (op_start_second <= cur_second && cur_second <= op_end_second)
            cur_second = op_end_second;
        
        return convertToString(cur_second);
    }

	private int convertToSecond(String time_str) {
	    String[] time = time_str.split(":");
	    int seconds = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
	    return (seconds);
	}
	
	private String convertToString(int seconds) {
	    StringBuilder sb = new StringBuilder();
        
	    if (seconds / 60 < 10) {
	        sb.append("0");
	        sb.append(Integer.toString(seconds / 60));
	    } else {
	        sb.append(Integer.toString(seconds / 60));
	    }
	    
	    sb.append(":");
	    
	    if (seconds % 60 < 10) {
	        sb.append("0");
	        sb.append(Integer.toString(seconds % 60));
	    } else {
	        sb.append(Integer.toString(seconds % 60));
	    }
        
	    return (sb.toString());
	}
}