class Solution {
	static boolean visit[];

	public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];


        for(int i=0; i<n; i++) {
        		if(visit[i] == false) {
        			answer++;
        			DFS(i, computers, n);
        		}
        }

        return answer;
    } // End of main

	static void DFS(int i, int computers[][], int n) {
		visit[i] = true;	

		for(int j=0; j<n; j++) {
			if(visit[j] == false && computers[i][j] == 1) {
				DFS(j, computers, n);
			}
		}

	} // End of DFS
} // End