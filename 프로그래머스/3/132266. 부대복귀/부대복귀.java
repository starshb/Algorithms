import java.util.*;

class Solution {
    private static List<List<Integer>> graph;
    private static int[] dis;
    private static final int MAX = 1_000_000_000;

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {

        graph = new ArrayList<>();
        for(int i=0; i<n+1; i++) graph.add(new ArrayList<>());

        for (int[] road : roads) {
            int s = road[0];
            int e = road[1];

            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        dis = new int[n+1];
        Arrays.fill(dis, MAX);
        dijkstra(destination);

        int[] ans = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            ans[i] = (dis[sources[i]] < MAX) ? dis[sources[i]] : -1;
        }
        return ans;
    }

    private static void dijkstra(int destination) {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(destination);
        dis[destination] = 0;

        while (!qu.isEmpty()){
            int cn = qu.poll();

            for(int i=0; i<graph.get(cn).size(); i++){
                int nn = graph.get(cn).get(i);
                if(dis[nn] > dis[cn]+1){
                    dis[nn] = dis[cn]+1;
                    qu.add(nn);
                }
            }
        }
    }
}