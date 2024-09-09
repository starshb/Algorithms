#include <iostream>
using namespace std;
typedef long long ll;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	ll N, K; cin >> N >> K;
	ll idx = 2;
	ll old = K;
	ll ans = 0;
	if (N > K) ans += (N - K) * K;

	while (K / idx > 100000) {
		ll current = K / idx;
		if (current < N && N <= old) {
			ll cnt = N - current;
			ans += cnt * (K % N + K % (current + 1)) / 2;
		}
		else if (N > old) {
			ll cnt = old - current;
			ans += cnt * (K % old + K % (current + 1)) / 2;
		}

		old = current;
		idx++;
	}

	if (old > N) old = N;
	while (old) {
		ans += K % old;
		old--;
	}

	cout << ans;
}