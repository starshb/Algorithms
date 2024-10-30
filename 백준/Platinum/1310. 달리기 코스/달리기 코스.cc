#include <iostream>
#include <algorithm>
#include <stack>
#include <vector>
typedef long long ll;
using namespace std;

int t, n;
ll x, y;
vector<pair<ll, ll>> pos;
vector<pair<ll, ll>> hull;
stack<pair<ll, ll>> stk;

// 시계 음수, 반시계 양수, 일직선 0
ll ccw(ll x1, ll y1, ll x2, ll y2, ll x3, ll y3) {
	return (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);
}

// x좌표 오름차순, y좌표 오름차순 정렬
// 가장 상단 왼쪽이 기준점
bool compAscXAscY(pair<ll, ll>& a, pair<ll, ll>& b) {
	if (a.first == b.first) return a.second < b.second;
	else return a.first < b.first;
}

// 기준점에서 시계 반대 방향으로 정렬
bool comp(pair<ll, ll>& a, pair<ll, ll>& b) {
	ll res = ccw(pos[0].first, pos[0].second, a.first, a.second, b.first, b.second);
	if (res == 0) { // 일직선인 경우 상단 좌측 순
		if (a.first == b.first) return a.second < b.second;
		else return a.first < b.first;
	}
	else {
		// 기준점, a, b가 반시계 방향을 이루도록 정렬
		return res > 0;
	}
}

ll getDist(ll x1, ll y1, ll x2, ll y2) {
	return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);


	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> x >> y;
		pos.push_back({ x, y });
	}

	sort(pos.begin(), pos.end(), compAscXAscY);
	sort(pos.begin() + 1, pos.end(), comp);

	stk.push(pos[0]);
	stk.push(pos[1]);

	for (int i = 2; i < pos.size(); i++) {
		while (stk.size() >= 2) {
			pair<ll, ll> a = stk.top();
			stk.pop();
			pair<ll, ll> b = stk.top();
			ll res = ccw(pos[i].first, pos[i].second, a.first, a.second, b.first, b.second);
			if (res < 0) {
				stk.push(a);
				break;
			}
		}
		stk.push(pos[i]);
	}

	while (!stk.empty()) {
		hull.push_back(stk.top()); // 스택이므로 hull에는 시계 방향으로 들어가게됨
		stk.pop();
	}

	// 시작 좌표 i, 그 다음 좌표 ni 
	// i, ni가 만들어내는 벡터와의 방향성을 검사할 j와 nj
	ll mx = 0;
	// j는 굳이 i 다음 위치부터 다시 시작할 필요가 없음.
	// 반시계 방향으로 회전하기 이전의 위치부터 다시 검사해주면 된다.
	int j = 1;
	for (int i = 0; i < hull.size(); i++) {
		int ni = (i + 1) % hull.size();
		while (1) {
			int nj = (j + 1) % hull.size();
			ll nx = hull[ni].first + (hull[nj].first - hull[j].first); // ni에 연결된
			ll ny = hull[ni].second + (hull[nj].second - hull[j].second); // 좌표로 바꿔줌
			ll res = ccw(hull[i].first, hull[i].second, hull[ni].first, hull[ni].second, nx, ny);
			if (res >= 0) break; // 시계 방향이 아니게 되면 그 시점에 거리 구해줌
			j = nj;
		}
		ll d = getDist(hull[i].first, hull[i].second, hull[j].first, hull[j].second);
		if (d > mx) {
			mx = d;
		}
	}
	cout << mx;
}