#include <iostream>
#include <string>
using namespace std;

int N;
int A[50];
string s;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> s;
		if (s.length() == 6) continue;
		A[i] = (s.front() - '0') * 1000 + stoi(s.substr(2, 3));
	}
	for (int k = 1; k < 10001; k++) {
		bool chk = 1;
		for (int i = 0; i < N; i++) {
			int L = 0, R = k * 10;
			while (L <= R) {
				int mid = (L + R) / 2;
				int val = 0;
				for (int _ = 0; _ < 4; _++) {
					val = val * 10 + mid / k;
					mid %= k;
					mid *= 10;
				}
				if (val < A[i]) L = (L + R) / 2 + 1;
				else if (val > A[i]) R = (L + R) / 2 - 1;
				else goto BREAK1;
			}
			chk = 0;
			goto BREAK2;
			BREAK1:
			1;
		}
		BREAK2:
		if (chk) {
			cout << k;
			return 0;
		}
	}
}