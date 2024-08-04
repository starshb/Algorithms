#include <bits/stdc++.h>
#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;

constexpr int INF = 1e9 + 7;

int main() {
	fastio;
	int n, m; cin >> n >> m;
	vector<int> v(m);
	for (int i = 0; i < m; i++) cin >> v[i];
	sort(v.begin(), v.end()); v.push_back(INF);

	vector<vector<int>> DP(m + 1, vector<int>(n + 1, -1)); DP[0][0] = v[0];
	for (int c = 0; c < m; c++) {
		const auto& val = v[c];
		const int mn = *min_element(v.begin() + c + 1, v.end());
		for (int i = m; i >= 0; i--) for (int j = n; j >= 0; j--) {
			if (DP[i][j] == -1) continue;
			if (i + 1 > m || j + val > n) continue;
			DP[i + 1][j + val] = i == c ? mn : max(DP[i + 1][j + val], DP[i][j]);
		}
	}

	int ans = m;
	for (int i = 0; i < m; i++) for (int j = 0; j <= n; j++) {
		if ((n - j) < DP[i][j] * (i + 1)) ans = min(ans, i);
	}
	cout << ans << '\n';
}