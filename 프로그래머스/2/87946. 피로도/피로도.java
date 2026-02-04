class Solution {
    public int solution(int energy, int[][] dungeons) {
    	boolean[] visited = new boolean[dungeons.length];
    	return search(dungeons, visited, energy, 0);
    }
    
    public int search(int[][] dungeons, boolean[] visited, int energy, int count) {
        int max = count; // 지금까지 탐험한 개수를 기준으로 시작

	    for (int i = 0; i < dungeons.length; i++) {
	        // 이미 갔거나, 최소 필요 피로도 조건을 만족하지 못하면 스킵
	        if (visited[i] || dungeons[i][0] > energy) {
	            continue;
	        }
	
	        visited[i] = true;
	        // 이 던전을 탐험한 뒤의 결과와 현재 max 중 더 큰 값을 선택
	        max = Math.max(
	            max,
	            search(dungeons, visited, energy - dungeons[i][1], count + 1)
	        );
	        visited[i] = false;
	    }
	
	    return max;
	}
}