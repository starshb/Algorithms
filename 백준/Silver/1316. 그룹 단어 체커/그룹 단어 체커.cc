#include <stdio.h>

int main() {
	int n;
	scanf("%d", &n);

	int a[26] = { 0, };
	char s[101];
	int ret = 0;
	int k, pass;

	for (int i = 0; i < n; ++i) {
		scanf("%s", &s);

		for (int j = 0; j < 26; ++j) {
			a[j] = 0;
		}

		k = 1;
		pass = 1;

		while (s[k]) {
			if (a[s[k] - 'a']) {
				pass = 0;
				break;
			}

			if (s[k] != s[k - 1]) {
				++a[s[k - 1] - 'a'];
			}
			++k;
		}

		ret += pass;
	}

	printf("%d\n", ret);
	return 0;
}