#include <iostream>
using namespace std;
typedef long long ll;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	ll N, K; cin >> N >> K;
	
	ll ans = 0;
	ll NN = 1;
	if (K == 1) cout << N;
	else {
		while (1) {
			ll x = (NN - ans - 1) / (K - 1) + 1;
			if (NN + x > N) {
				ans += (N - NN) * K;
				break;
			}
			ans = (ans + K * x) % (NN + x);
			NN += x;
		}

		cout << ans + 1;
	}
}