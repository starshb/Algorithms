#include <bits/stdc++.h>
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0)
using namespace std;

#define X first
#define Y second
using ll = long long;
using pii = pair<int, int>;
using pli = pair<ll, int>;
const ll INF = ll(1e18);

struct Area {
	pii st, en;
	ll cost;
};

struct Point {
	pii pos;
	ll cost[4];
};

int N, n, m;
pii st, en;
vector<Area> v;
vector<int> x_pos, y_pos;
Point node[2002][2002];

ll dist[2002 * 2002];
ll A_Star() {
	fill(dist, dist + n * m, INF);
	priority_queue<pli, vector<pli>, greater<pli>> PQ;
	auto H = [&](int nidx) {
		return 1LL * abs(x_pos[en.X] - x_pos[nidx / m]) + 1LL * abs(y_pos[en.Y] - y_pos[nidx % m]);
	};
	dist[st.X * m + st.Y] = 0;
	PQ.push({ dist[st.X * m + st.Y] + H(st.X * m + st.Y), st.X * m + st.Y });
	while (!PQ.empty()) {
		auto [cost, idx] = PQ.top(); PQ.pop();
		if (idx == en.X * m + en.Y) return dist[idx];
		if (cost != dist[idx] + H(idx)) continue;
		int x = idx / m, y = idx % m;
		for (int k = 0; k < 4; k++) {
			int nx = x + "1012"[k] - '1';
			int ny = y + "2101"[k] - '1';
			int nidx = nx * m + ny;
			if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
			if (dist[nidx] > dist[idx] + node[x][y].cost[k]) {
				dist[nidx] = dist[idx] + node[x][y].cost[k];
				PQ.push({ dist[nidx] + H(nidx), nidx });
			}
		}
	}
}

int main() {
	fastio;

	//입력
	cin >> st.X >> st.Y >> en.X >> en.Y >> N;
	x_pos.push_back(st.X), x_pos.push_back(en.X);
	y_pos.push_back(st.Y), y_pos.push_back(en.Y);
	v.resize(N);
	for (int i = 0; i < N; i++) {
		int a, b, c, d, e; cin >> a >> b >> c >> d >> e;
		v[i] = { {a, b}, {c, d}, e };
		x_pos.push_back(a), x_pos.push_back(c);
		y_pos.push_back(b), y_pos.push_back(d);
	}

	//좌표압축
	sort(x_pos.begin(), x_pos.end());
	sort(y_pos.begin(), y_pos.end());
	x_pos.erase(unique(x_pos.begin(), x_pos.end()), x_pos.end());
	y_pos.erase(unique(y_pos.begin(), y_pos.end()), y_pos.end());
	st.X = lower_bound(x_pos.begin(), x_pos.end(), st.X) - x_pos.begin();
	st.Y = lower_bound(y_pos.begin(), y_pos.end(), st.Y) - y_pos.begin();
	en.X = lower_bound(x_pos.begin(), x_pos.end(), en.X) - x_pos.begin();
	en.Y = lower_bound(y_pos.begin(), y_pos.end(), en.Y) - y_pos.begin();
	n = x_pos.size(), m = y_pos.size();

	//간선 만들기
	for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) {
		int x = x_pos[i];
		int y = y_pos[j];
		node[i][j].pos = { x, y };
		for (int k = 0; k < 4; k++) {
			int nx = i + "1012"[k] - '1';
			int ny = j + "2101"[k] - '1';
			if (nx < 0 || nx >= n || ny < 0 || ny >= m) node[i][j].cost[k] = INF;
			else node[i][j].cost[k] = 10LL * abs(x_pos[nx] - x) + 10LL * abs(y_pos[ny] - y);
		}
	}
	
	for (auto& cur : v) {
		int i1 = lower_bound(x_pos.begin(), x_pos.end(), cur.st.X) - x_pos.begin();
		int i2 = lower_bound(x_pos.begin(), x_pos.end(), cur.en.X) - x_pos.begin();
		int j1 = lower_bound(y_pos.begin(), y_pos.end(), cur.st.Y) - y_pos.begin();
		int j2 = lower_bound(y_pos.begin(), y_pos.end(), cur.en.Y) - y_pos.begin();
		ll cost = cur.cost;
		for (int i = i1; i <= i2; i++) for (int j = j1; j <= j2; j++) {
			for (int k = 0; k < 4; k++) {
				int nx = i + "1012"[k] - '1';
				int ny = j + "2101"[k] - '1';
				if (nx < i1 || nx > i2 || ny < j1 || ny > j2) continue;
				if (!(i == nx && i1 < nx && nx < i2 || j == ny && j1 < ny && ny < j2)) continue;
				node[i][j].cost[k] = cost * abs(node[nx][ny].pos.X - node[i][j].pos.X) + cost * abs(node[nx][ny].pos.Y - node[i][j].pos.Y);
			}
		}
	}

	//A_Star Algorithm
	cout << A_Star() << '\n';
}