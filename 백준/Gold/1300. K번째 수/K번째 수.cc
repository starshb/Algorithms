#include <iostream>
#include <algorithm>

using namespace std;

int N, k;

int main(void)
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	cin >> N >> k;

	int f = 1, l = k, m;
	int res = 0;

	for (;;)
	{
		if (f > l) break;
		m = (f + l) / 2;

		int cnt = 0;
		for (int i = 1; i <= N; i++)
		{
			cnt += min(N, m / i);
		}

		if (cnt >= k)
		{
			res = m;
			l = m - 1;
		}
		else
		{
			f = m + 1;
		}
	}

	cout << res << '\n';

	return 0;
}