import java.util.TreeMap;

class Solution {
    static final int DEFAULT_EXIT_TIME = 23 * 60 + 59; 
    
    public int[] solution(int[] fees, String[] records) {
        TreeMap<String, String> parkingRecord = new TreeMap<>();
        TreeMap<String, Integer> timeAccRecord = new TreeMap<>();
        TreeMap<String, Integer> feeRepository = new TreeMap<>();
        
        for (String record : records) {
            String[] args = record.split(" ");
            
            String time = args[0];
            String carNumber = args[1];
            String recordType = args[2];
            
            if ("IN".equals(recordType)) {
                parkingRecord.put(carNumber, time);
            }
            
            if ("OUT".equals(recordType)) {
                int t = calculateTime(parkingRecord.get(carNumber), time);
                timeAccRecord.put(carNumber, timeAccRecord.getOrDefault(carNumber, 0) + t);
                parkingRecord.remove(carNumber);
            }
        }
        
        parkingRecord.keySet().stream()
            .forEach(
                 carNum -> {
                     int t = calculateTime(parkingRecord.get(carNum), "23:59");
                     timeAccRecord.put(carNum, timeAccRecord.getOrDefault(carNum, 0) + t);
                     feeRepository.put(carNum, calculateFee(timeAccRecord.get(carNum), fees));
                 }
        );
        
        return timeAccRecord.keySet().stream()
            .map(timeAccRecord::get)
            .mapToInt(accTime -> calculateFee(accTime, fees))
            .toArray();
    }
    
    private int calculateTime(String in, String out) {
        int inTime = Integer.parseInt(in.substring(0, 2)) * 60 + Integer.parseInt(in.substring(3, 5));
        int outTime = Integer.parseInt(out.substring(0, 2)) * 60 + Integer.parseInt(out.substring(3, 5));
        
        return outTime - inTime;
    }
    
    private int calculateFee(int time, int[] fees) {
        int overTime = Math.max((time - fees[0]), 0);
        
        if (overTime == 0) return fees[1];
        if (overTime % fees[2] == 0) return (overTime / fees[2]) * fees[3] + fees[1];
        
        return (overTime / fees[2] + 1) * fees[3] + fees[1];
    }
}

