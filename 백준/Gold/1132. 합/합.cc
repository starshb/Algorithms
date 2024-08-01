#include <bits/stdc++.h>
using namespace std;
long long alpha[10];	// alpha[0]: A, alpha[1]: B, ... , alpha[9]: J
long long ans;
bool notzero[10];	// 0이면 안되는 알파벳 = 1
 
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int N, i, j;
	cin >> N;
	for (i = 0; i < N; i++) {
		string input;
		cin >> input;
		notzero[input[0] - 'A'] = 1;	// 첫 번째 자리에 있는 알파벳은 0이 되면 안 됨
		long long k = 1;
		for (j = input.size() - 1; j >= 0; j--) {
			alpha[input[j] - 'A'] += k;
			k *= 10;
		}
	}
	bool flg = 0;
	for (i = 0; i < 10; i++)
		if (!alpha[i])
			flg = 1;
	if (!flg) {
		// A부터 J까지의 모든 알파벳이 사용된 경우에는 어딘가에 0을 줘야 함
		// 0이 되도 괜찮은 것 중 가장 작은 것에 0을 배정
		long long min = 10000000000000000;
		int idx;	// 0을 배정할 알파벳 index
		for (i = 0; i < 10; i++) {
			if (!notzero[i] && alpha[i] < min) {
				min = alpha[i];
				idx = i;
			}
		}
		alpha[idx] = 0;	// 가장 작은 것에 0 배정
	}
	sort(alpha, alpha + 10, greater<>());	// 내림차순 정렬
	for (i = 0, j = 9; i < 10; i++, j--)
		ans += alpha[i] * j;	// 각 알파벳에 숫자 배정 후 계산
	cout << ans;
}