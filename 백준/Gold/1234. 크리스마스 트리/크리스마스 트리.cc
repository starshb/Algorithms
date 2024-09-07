#include <cstdio>
#include <cstring>
#define min(a,b) (a < b ? a : b)

typedef long long ll;

ll dp[15][60][60];
int f[15];
int n, red, green, blue;
int d[7][3] = { {1,0,0},{0,1,0}, {0,0,1},{1,1,0},{1,0,1},{0,1,1},{1,1,1} };

void get_factorial(int n) {
	f[0] = 1;
	for (int i = 1; i <= n; i++) 
		f[i] = f[i - 1] * i;
}

ll get_dp(int lv, int r, int g, int b) {
	if (lv == n + 1) return 1;
	ll& ret = dp[lv][r][g];
	if (ret != -1) return ret;
	ret = 0;
	for (int i = 0; i < 7; i++) {
		if (lv % (i / 3 + 1)) continue;
		int val = lv / (i / 3 + 1);
		int nr = r - d[i][0] * val, ng = g - d[i][1] * val, nb = b - d[i][2] * val;
		if (nr < 0 || ng < 0 || nb < 0) continue;
		ll cnt = 1LL * f[lv] / (f[d[i][0] * val] * f[d[i][1] * val] * f[d[i][2] * val]);
		ret += cnt * get_dp(lv + 1, nr, ng, nb);
	}
	return ret;
}

int main() {
	memset(dp, -1, sizeof(dp));
	scanf("%d %d %d %d", &n, &red, &green, &blue);
	get_factorial(n);
	red = min(red, 55);
	green = min(green, 55);
	blue = min(blue, 55);
	printf("%lld\n", get_dp(1, red, green, blue));
	return 0;
}