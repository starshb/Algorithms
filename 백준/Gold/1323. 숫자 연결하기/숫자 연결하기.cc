#include<iostream>
#include<cmath>
#include<algorithm>
using namespace std;
 
bool check[100001] = { 0 };
 
long long make_digit(int n) {
	long long digit = 0;
	while (n > 0) {
		digit++;
		n /= 10;
	}
	digit = pow(10, digit);
	return digit;
}
 
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int n, k;
	cin >> n >> k;
	long long digit = make_digit(n);
	
	int cnt = 1;
	int remainder = n % k;
	bool flag = true;
	while (remainder != 0) {
		remainder = (remainder*digit + n) % k;
		if (check[remainder]) {
			flag = false;
			break;
		}
		check[remainder] = true;
		cnt++;
	}
	if (flag) {
		cout << cnt << "\n";
	}
	else {
		cout << "-1\n";
	}
	return 0;
}