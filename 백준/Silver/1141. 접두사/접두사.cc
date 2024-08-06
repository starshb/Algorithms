#include <bits/stdc++.h>

using namespace std;

int main(void)
{
	int n;
	cin >> n;

	vector<string> v(n);
	vector<bool> check(n, true);

	for (int i = 0; i < n; i++)
		cin >> v[i];

	sort(v.begin(), v.end());

	for (int i = 0; i < v.size(); i++)
	{
		for (int j = i + 1; j < v.size(); j++)
		{
			if (v[j].substr(0, v[i].size()) == v[i])
			{
				check[i] = false;
				break;
			}
		}
	}

	int ans = 0;
	for (auto i : check)
		if (i)
			ans++;

	cout << ans;
	return 0;
}