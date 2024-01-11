import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    //인접 리스트에 그래프 저장
    public int solution(int n, int[][] edge) {
        for(int i = 0 ; i <= n ; i++) graph.add(new ArrayList<>());
		
		for (int[] i : edge) {
			int v = i[0];
			int w = i[1];
			graph.get(v).add(w);
			graph.get(w).add(v);
		}

		boolean[] visit = new boolean[n + 1];
        return bfs(graph, n, visit);
    }
    
    public static int bfs(ArrayList<ArrayList<Integer>> graph, int n, boolean[] visit) {
		Queue<int[]> q = new LinkedList<>();
		int answer = 0;
		
		q.add(new int[] {1, 0});
		visit[1] = true;
		int maxDepth = 0;
		
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int v = arr[0];
			int depth = arr[1];
			
            
			if(maxDepth == depth) answer++; // 최대 길이 노드라면 answer++;
			else if (maxDepth < depth) { // 더 긴 거리에 노드가 있다면 answer = 1, MaxDepth 갱신
				maxDepth = depth;
				answer = 1;
			}

			
			for (int i = 0; i < graph.get(v).size(); i++) {
				int w = graph.get(v).get(i); //인접 정점
				if (!visit[w]) {
					q.add(new int[] { w, depth + 1 });
					visit[w] = true;
				}
			}
		}

		return answer;
	}
}