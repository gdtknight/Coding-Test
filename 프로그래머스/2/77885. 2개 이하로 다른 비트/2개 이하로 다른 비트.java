class Solution {
    public long[] solution(long[] numbers) {
        long[] results = new long[numbers.length];
        
        String binaryStr = null;
        StringBuilder answerBuilder = null;
        
        for (int idx = 0; idx < numbers.length; idx++) {
            long number = numbers[idx];
            
            binaryStr = Long.toBinaryString(number);
            answerBuilder = new StringBuilder(binaryStr);
            
            int firstIdxOfOne = binaryStr.indexOf("1");
            int lastIdxOfZero = binaryStr.lastIndexOf("0");
            
            if(firstIdxOfOne < lastIdxOfZero) {
                answerBuilder.setCharAt(lastIdxOfZero, '1');
                if (lastIdxOfZero != binaryStr.length() - 1) {
                    answerBuilder.setCharAt(lastIdxOfZero + 1, '0');
                }
            } else {
                answerBuilder.setCharAt(firstIdxOfOne, '0');
                
                if (firstIdxOfOne == 0) {
                    answerBuilder.insert(0, "1");
                } else {
                    answerBuilder.setCharAt(firstIdxOfOne - 1, '1');
                }
            }
            
            // System.out.println("First 1 at " + firstIdxOfOne + ", Last 0 at " + lastIdxOfZero);
            // System.out.println(binaryStr);
            // System.out.println(answerBuilder);
            
            results[idx] = Long.parseLong(answerBuilder.toString(), 2);
        }
        
        return results;
    }
}