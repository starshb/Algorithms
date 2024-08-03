#include <bits/stdc++.h>
using namespace std;
typedef pair<int, int> pii;

int n;
vector<int>tree[55];

int solve(int node) {
	// 리프노드라면
	if (tree[node].empty()) {
		return 1;
	}
	// 리프노드가 아니라면
	// 자식 노드의 cost 배열에서 각 index를 + 해주고 그 중 max 값이 걸리는 시간임 = 즉 해당 노드의 cost
	// 해당 노드의 cost 값을 구하려면 자식 노드들의 값이 전부 구해져 있어야 한다.
	vector<int>child;
	for (int i = 0; i < tree[node].size(); i++) {
		child.push_back(solve(tree[node][i]) + 1); // 해당 노드도 전파 횟수에 추가되어야 함, 즉 + 1
	}
	sort(child.begin(), child.end(), greater<int>());
	int ret = 0;
	for (int i = 0; i < child.size(); i++) {
		ret = max(ret, child[i] + i);
	}
	return ret;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> n;
	vector<int>v(n);
	for (int i = 0; i < n; i++) {
		cin >> v[i];
		if (i == 0) continue; 
		tree[v[i]].push_back(i); // 자식 노드들을 가지고 있음
	}
	// -1 하는 이유는 root 노드는 제외
	cout << solve(0) - 1 << "\n";
}
