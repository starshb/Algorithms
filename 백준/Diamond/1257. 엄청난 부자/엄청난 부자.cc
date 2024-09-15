#include <iostream>
#include <algorithm>
#include <cstring>
#include <queue>
#include <vector>

using namespace std;

typedef long long int lld;
typedef pair<int, int> pii;

const int INF = 987654321;
const int MAX_N = 1001;
const int MAX_C = 10001;

lld M;
int N;
int A[MAX_N];
vector<pii> vertex[MAX_C];
int dist[MAX_C];

struct cmp {
    bool operator()(int a, int b) {
        return dist[a] > dist[b];
    }
};

priority_queue<int, vector<int>, cmp> pq;

void input() {
    fill(dist, dist + MAX_C, INF);
    
    cin >> M;
    cin >> N;
    for(int i=0; i<N; i++)
        cin >> A[i];
    sort(A, A + N);
}

void solve() {
    dist[0] = 0;
    for(int i=0; i<A[N-1]; i++) {
        for(int j=0; j<N-1; j++) {
            int v = i + A[j], c = v<A[N-1];
            vertex[i].push_back({v%A[N-1], c});
        }
    }
    
    pq.push(0);
    while(!pq.empty()) {
        int t = pq.top(); pq.pop();
        for(auto x : vertex[t]) {
            int v = x.first, c = x.second;
            if(dist[t] + c < dist[v]) {
                dist[v] = dist[t] + c;
                pq.push(v);
            }
        }
    }
    
    cout << M/A[N-1] + dist[M%A[N-1]];
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    
    input();
    
    solve();
    
    return 0;
}