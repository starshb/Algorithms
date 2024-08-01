#include <bits/stdc++.h>
#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;

enum { white, gray = -1 };

int DP[10'000'001];
int a, b, k, p[10];

void Init() {
	for (int i = 0; i < 10; i++) {
		p[i] = i;
		for (int j = 1; j < k; j++) p[i] *= i;
	}
}

int f(int n) {
	int ret = 0;
	while (n) ret += p[n % 10], n /= 10;
	return ret;
}

int DFS(int cur) { //cur_min
	int& ret = DP[cur];
	if (ret != white && ret != gray) return ret;
	else if (ret == white) {
		ret = gray;
		ret = DFS(f(cur));
		return ret = min(ret, cur);
	}
	else if (ret == gray) {
		int mn = cur;
		for (int i = f(cur); i != cur; i = f(i)) mn = min(mn, i);
		for (int i = f(cur); i != cur; i = f(i)) DP[i] = mn;
		return ret = mn;
	}
}

int main() {
	fastio;
	cin >> a >> b >> k; Init();
	int64_t ans = 0;
	for (int i = a; i <= b; i++) ans += DFS(i);
	cout << ans << '\n';
}