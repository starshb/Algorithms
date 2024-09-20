#include <iostream>
#include <vector>
#include <queue>
#define N_MAX 1001
using namespace std;

// 그래프 선언 (연결된 node 와 그 노드까지 가는 거리가 튜플로 저장)
vector< pair<int, int> > graph[N_MAX];

// 방문 확인 배열 선언
bool is_visit[N_MAX];

// 방문 배열 false 로 초기화
void init_is_visit () {
    for(int i = 0; i < N_MAX; i++) {
        is_visit[i] = false;
    }
}

// 결과 저장 변수 선언
int answer = 0;

// DFS 탐색
void DFS(int current_node, int dest_node, int distance) {

    // 종료조건 : current_node 와 dest_node 가 일치하면 도달했으므로 종료
    if(current_node == dest_node) {
        answer = distance;
        return;
    }

    // 종료조건이 아니라면
    for(int i = 0; i < graph[current_node].size(); i++) {
        int n_node = graph[current_node][i].first;
        int n_dist = graph[current_node][i].second;
        // next_node 를 방문하지 않았다면 방문
        if(is_visit[n_node] == false) {
            is_visit[n_node] = true;
            DFS(n_node, dest_node, (distance + n_dist));
            // 끝까지 탐색했지만 n2 에 도달하지 못했다면 돌아와서 다시 탐색해야하므로 방문 여부 다시 false 로
            is_visit[n_node] = false;
        }
    }
}

// BFS 탐색
int BFS(int current_node, int dest_node) {
    // 탐색할 queue 선언 (first element: current_node, second element: 처음 BFS 가 불렸을때의 node 에서부터 떨어진 distance)
    queue< pair<int, int> > q;

    // current_node 방문 여부 update 후 q에 넣고 탐색 시작
    is_visit[current_node] = true;
    q.push(make_pair(current_node, 0));

    // BFS 탐색 시작
    while(!q.empty()) {
        int c_node = q.front().first;
        int c_dist = q.front().second;
        q.pop();

        // 종료조건: c_node 와 dest_node 가 일치하면 도달했으므로 종료
        if(c_node == dest_node) {
            return c_dist;
        }

        for(int i = 0; i < graph[c_node].size(); i++) {
            int n_node = graph[c_node][i].first;
            int n_dist = graph[c_node][i].second;
            // next_node 를 방문하지 않았다면 방문하기 위해 queue 에 push
            if(is_visit[n_node] == false) {
                is_visit[n_node] = true;
                q.push(make_pair(n_node, (c_dist+n_dist)));
            }
        }
    }

    return -1;
}

int main() {
    // 노드의 개수 N, 거리를 알고싶은 노드 쌍의 개수 M 입력
    int N = 0, M = 0;
    cin >> N >> M;

    // N-1 개의 줄에 트리 상에 연결된 두 점과 거리 입력 (n1 n2 distance)
    for(int i = 0; i < N-1; i++) {
        int n1 = 0, n2 = 0, dist = 0;
        cin >> n1 >> n2 >> dist;

        // graph 에 저장
        graph[n1].push_back(make_pair(n2, dist));
        graph[n2].push_back(make_pair(n1, dist));
    }

    // M 개의 줄에 걸쳐 거리를 알고싶은 노드 쌍 입력 (n1 n2)
    for(int i = 0; i < M; i++) {
        int n1 = 0, n2 = 0;
        cin >> n1 >> n2;

        // 방문한 배열 false 로 초기화
        init_is_visit();

        // 입력받은 n1 부터 n2 에 도달할 때까지 탐색
        // DFS : n1 에 대해 방문여부 update
        is_visit[n1] = true; 
        DFS(n1, n2, 0);
        is_visit[n1] = false;

        // DFS 결과 출력
        cout << answer << endl;

        // int result = BFS(n1, n2);

        // BFS 결과 출력
        // cout << result << endl;
    }

    return 0;
}