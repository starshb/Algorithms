class Solution {
    
	static int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        int totalSize = arr.length;
        dq(0,0,totalSize,arr);
        
        return answer;
    }
    
    	private static void dq(int startX, int startY, int size, int[][] arr) {
		if(check(startX, startY, size, arr)) {
			answer[arr[startX][startY]]++;
			return;
		}
		dq(startX, startY, size / 2, arr);
		dq(startX + size / 2, startY, size / 2, arr);
		dq(startX, startY + size / 2, size / 2, arr);
		dq(startX + size / 2, startY + size / 2, size / 2, arr);
	}
 
	private static boolean check(int x, int y, int size, int[][] arr) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if(arr[x][y] != arr[i][j]) return false;
			}
		}
		return true;
	}
}