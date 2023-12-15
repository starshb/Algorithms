import java.util.*;

class Solution {
    
    private List<Node>[] graphs = new ArrayList[50010];


    private int[] visited = new int[50010];
    private boolean[] isSummits = new boolean[50010];
    private PriorityQueue<Curr> pq = new PriorityQueue<Curr>();
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        for (int i = 0; i < graphs.length; i++) {
            graphs[i] = new ArrayList<Node>();
        }
        for (int i=0; i<=n; i++) {
            visited[i] = 1000000000;
        }
        for (int i=0; i<summits.length; i++) {
            isSummits[summits[i]] = true;
        }
        for (int[] path: paths) {
            int x = path[0];
            int y = path[1];
            int z = path[2];
            graphs[x].add(new Node(y, z));
            graphs[y].add(new Node(x, z));
        }
        for(int gate: gates) {
            visited[gate] = 0;
            pq.add(new Curr(gate, 0));
        }
        
        while (pq.size() != 0) {
            Curr curr = pq.poll();
            if (visited[curr.node] < curr.dist) continue;
            for (Node next: graphs[curr.node]) {
                if (visited[next.x] <= Math.max(curr.dist, next.y)) continue;
                visited[next.x] = Math.max(curr.dist, next.y);
                if (isSummits[next.x]) continue;
                pq.add(new Curr(next.x, visited[next.x]));
            }
        }
        
        int mini = 1000000000;
        int node = 0;
        for (int summit: summits) {
            if (visited[summit] < mini) {
                mini = visited[summit];
                node = summit;
            } else if (visited[summit] == mini && summit < node) {
                mini = visited[summit];
                node = summit;              
            }
        }
        int[] answer = {node, mini};
        return answer;
    }
    
    static class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static class Curr implements Comparable<Curr> {
        int node;
        int dist;
        
        public Curr(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
        
        @Override
        public int compareTo(Curr a) {
            return this.dist - a.dist;
        }
        
    }
}