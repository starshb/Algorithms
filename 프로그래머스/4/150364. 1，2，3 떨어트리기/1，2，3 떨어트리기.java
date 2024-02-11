import java.util.*;

class Solution {
    public int[] solution(int[][] edges, int[] target) {
        int n = edges.length + 1;
        int T = 0;

        // 트리 생성
        ArrayList<Integer>[] tree = new ArrayList[n];
        for(int i=0;i<n;i++) tree[i] = new ArrayList<>();
        for (int i=0;i<edges.length;i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            tree[parent-1].add(child-1);
        }
        for (int i=0;i<n;i++) Collections.sort(tree[i]);

        // 현재 노드가 몇 번 지나갔는지 체크
        int[] pass = new int[n];
        // 현재 노드가 보유하고 있는 숫자 개수
        int[] cnt = new int[n];
        // 체크한 노드인지 저장
        boolean[] check = new boolean[n];
        // 리프 노드 저장
        ArrayList<Integer> Q = new ArrayList<>();

        // 리프 노드이고 (트리에 자식 노드가 없을 경우) 타겟에 수가 0보다 크다면 케이스에 추가
        for (int i=0;i<n;i++) if (tree[i].isEmpty() && target[i]>0) T++;

        // 케이스 실행
        while (T>0) {
            // 루트 노드에서부터 시작
            int node = 0;

            // 리프 노드까지 숫자 떨어뜨리기
            // 이 때 간선이 주기적으로 바뀌기 때문에 (현재 노드를 지난 횟수 % 자식 노드의 개수) 값으로 노드가 설정됨
            while (tree[node].size()>0) node = tree[node].get(pass[node]++ % tree[node].size());

            // 리프 노드에 떨어진 숫가 개수 증가
            cnt[node]++;
            // 리프 노드 저장
            Q.add(node);

            // 현재 노드가 보유하고 있는 숫자 개수 > 노드의 target 값이라면 모든 수를 1로 변경해도 수를 만족시킬 수 없으므로 -1 리턴
            if (cnt[node] > target[node]){
                int[] answer = {-1};
                return answer;
            }

            // 노드의 target 값 ≤ 현재 노드가 보유하고 있는 숫자 개수 * 3 이고 방문하지 않았으면 조건에 만족, 다음 케이스로 넘어감
            if (!check[node] && target[node] <= 3 * cnt[node]){
                check[node] = true;
                T--;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        // 저장된 리프 노드들 탐색
        for (int i : Q) {
            // 개수를 하나씩 줄여가면서 1,2,3을 작은 순부터 대입
            cnt[i]--;
            for (int val=1;val<=3;val++) {
                // val = 대입한 수라고 했을 떄 target 값에서 val을 뺐을 때도 조건을 만족해야 함
                // 조건 만족할 경우 정답에 추가
                if (cnt[i] <= target[i] - val && target[i] - val <= 3 * cnt[i]) {
                    res.add(val);
                    target[i] -= val;
                    break;
                }
            }
        }
        
        int[] answer = new int[res.size()];
        for(int i=0;i<res.size();i++) answer[i] = res.get(i);
        return answer;
    }
}