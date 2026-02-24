import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (String[] a, String[] b) -> Integer.compare(encode(a[0]), encode(b[0])));
        
        PriorityQueue<Schedule> pq = new PriorityQueue<>();
        
        int answer = 0;
        for (int idx = 0; idx < book_time.length; idx++) {
            Schedule newSchedule = new Schedule(book_time[idx]);
            while (!pq.isEmpty()
                   && (pq.peek().checkOutTime() + 10 <= newSchedule.checkInTime()))
                pq.poll();
            pq.offer(newSchedule);
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }
    
    public int encode(String time) {
        String[] vals = time.split(":");
        return (Integer.parseInt(vals[0]) * 60 + Integer.parseInt(vals[1]));
    }
	
	class Schedule implements Comparable<Schedule> {
	    String checkIn;
	    String checkOut;
	    
	    Schedule(String[] arr) {
	        checkIn = arr[0];
	        checkOut = arr[1];
	    }
        
        public int checkInTime() {
            return (encode(checkIn));
        }
        
        public int checkOutTime() {
            return (encode(checkOut));
        }
	    
        @Override
	    public int compareTo(Schedule o) {
	        return (Integer.compare(
	            encode(this.checkOut),
	            encode(o.checkOut)));
	    }
	}
}
