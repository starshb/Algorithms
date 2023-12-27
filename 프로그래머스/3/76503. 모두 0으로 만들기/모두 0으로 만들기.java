import java.util.*;

class Solution {
    public long[] a;
    public int n;
    public long answer = 0;
    public ArrayList<Integer>[] map;
    public int[] indegree;
    public int root = 0;

    public long solution(int[] atmp, int[][] edges) {
        n = atmp.length;
        a = new long[n];
        for(int i=0; i<n; i++){
            a[i] = atmp[i];
            answer += a[i];
        }
        if(answer!=0) return -1;
        if(n==2) return Math.abs(a[0]);
        
        map = new ArrayList[n];
        for(int i=0; i<n; i++){
            map[i] = new ArrayList<>();
        }
        indegree = new int[n];
        for(int i=0; i<edges.length; i++){
            map[edges[i][0]].add(edges[i][1]);
            map[edges[i][1]].add(edges[i][0]);
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<n; i++){
            if(map[i].size()==1) queue.add(i);
        }
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            
            answer += Math.abs(a[tmp]);
            indegree[tmp]--;
            
            for(int i=0; i<map[tmp].size(); i++){
                int next = map[tmp].get(i);
                if(indegree[next]==0) continue;
                indegree[next]--;
                a[next] += a[tmp];
                if(indegree[next]==1){
                    if(next == root) continue;
                    queue.add(next);
                }
            }
        }
        
        return answer;
    }
}