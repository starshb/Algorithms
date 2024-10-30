#include<iostream>
#include<vector>
#include<algorithm>
#include<cmath>

using namespace std;

int n;
vector<int>work[21];
vector<int>dp;
int inf = 987654321;

void make_works()
{
	cin >> n;
	for (int i = 0; i < n; i++){
		for (int j = 0; j < n; j++) {
			int w;
			cin >> w;
			work[i].push_back(w);
		}
	}
}

// bitmask 이용한 dp (초기화 : inf)
// 수행한 작업(i)을 n 길이의 bit의 1로 켠다.
// i번째 비트 켜기 : bit | (1<<i)
// i번째 비트 끄기 : bit & ~(1<<i)
// i번째 비트 켜져 있는 지 확인 : bit & (1<<i)
// dp[bit | (1<<i)] = min(dp[bit | (1<<i)], dp[bit]+work[x][i])
// x : bit에 있는 1의 개수

int count_bit(int num)
{
	int cnt = 0;
	while (num) {
		cnt += (num & 1);
		num >>= 1;
	}
	return cnt;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	make_works();
	
	for (int i = 0; i < pow(2, n); i++) {
		dp.push_back(inf);
	}
	dp[0] = 0;

	for (int i = 0; i < pow(2, n); i++) {
		int x = count_bit(i);
		for (int j = 0; j < n; j++) {
			if (!(i & (1 << j))) {
				dp[i | (1 << j)] = min(dp[i | (1 << j)], dp[i] + work[x][j]);
			}
		}
	}

	cout << dp[dp.size() - 1];
}