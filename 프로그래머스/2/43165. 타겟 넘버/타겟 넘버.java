import java.util.Stack;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Stack<Sum> stack = new Stack<>();
        Sum cur = new Sum(0, numbers[0]);
        stack.push(cur);
        cur = new Sum(0, -numbers[0]);
        stack.push(cur);
        
        
        while(!stack.isEmpty()) {
            cur = stack.pop();
            
            if (cur.getIdx() == numbers.length - 1 && cur.getSum() == target) {
                answer++; 
            }
            
            if (cur.getIdx() < numbers.length - 1) {
                stack.push(new Sum(cur.getIdx() + 1, cur.getSum() + numbers[cur.getIdx() + 1]));
                stack.push(new Sum(cur.getIdx() + 1, cur.getSum() - numbers[cur.getIdx() + 1]));
            }
        }
        
        return answer;
    }
}

class Sum {
    private int idx;
    private int sum;
    
    public Sum(int idx, int sum) {
        this.idx = idx;
        this.sum = sum;
    }
    
    public int getIdx() {
        return this.idx;
    }
    
    public int getSum() {
        return this.sum;
    }
}