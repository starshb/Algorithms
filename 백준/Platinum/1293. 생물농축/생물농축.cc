#include<bits/stdc++.h>
#define FAST ios_base::sync_with_stdio(false),cin.tie(NULL);
#define mset(v) memset(v,0,sizeof(v));
#define rep(i,a) for(int i=0;i<a;++i)
#define REP(i,a) for(int i=1;i<=a;++i)

using namespace std;

typedef long long ll;
typedef pair<int, int> pi;
typedef tuple<int, int, int>ti;
typedef vector<int> vi;
typedef vector<vector<int>> vvi;
int dy[] = { -1,0,1,0 }, dx[] = { 0,1,0,-1 };
int N, M, a, b, C[1001], H[1001], E[1001], J[1001], n[1001], INF = 987654321, dis[1001], dp[10001];
vi adj[1001], m[1001];
int knapsack(int k) {
	dp[0] = 0;
	fill(dp + 1, dp + 10001, INF);
	for (auto r : m[k]) {
		if (dis[r])continue; //멸종되어 없음
		for (int i = 1; i <= E[r]; i++) {
			dp[i] = min(dp[i], J[r]);
		}
		for (int i = E[r]; i <= C[k]; i++) {
			dp[i] = min(dp[i], min(dp[i - E[r]], dp[i - (i % E[r])]) + J[r]); //점화식 
		}
	}
	return dp[C[k]];
}

int main() {
	FAST;
	cin >> N;
	REP(i, N) {	
		cin >> C[i] >> H[i] >> E[i];
		//C[i] 섭취해야 할 칼로리
		//H[i] 보유가능한 최대 중금속
		//E[i] 보유한 칼로리(먹힐때)
		//J[i] 보유한 칼로리(DP + 위상정렬로 구하자)
		if (!C[i])J[i] = H[i];
	}
	cin >> M;
	while (M--) {
		cin >> a >> b;
		n[b]++;
		adj[a].push_back(b);
		m[b].push_back(a);
	}
	queue<int>Q;
	REP(i, N)if (!n[i])Q.push(i);
	while (!Q.empty()) { //위상정렬
		auto f = Q.front();
		Q.pop();
		for (auto r : adj[f]) {
			if (!(--n[r])) {
				Q.push(r);
				J[r] = knapsack(r); //보유한 중금속 저장
				if (H[r] < J[r])dis[r] = 1;//멸종
			}
		}
	}
	
	dis[N] ? cout << "no" : cout << "yes\n" << J[N];
}