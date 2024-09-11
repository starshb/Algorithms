#include<iostream>
#include<algorithm>

using namespace std;

int main(void) {
	int N, K, M;

	cin >> N >> K >> M;
	
	int cnt=0;
	int target;
	if (K%N)target = K%N;
	else target = N;	//target이 0이 될때를 고려
	while (1) {
		cnt++;
		if (target == M) {
			break;
		}
		if (M - target > 0) {
			M -= target;
			N--;
			if(K%N)target = K%N;
			else target = N;
		}
		else {
			M -= target;
			M = N + M;
			N--;
			if (K%N)target = K%N;
			else target = N;
			
		}
	}
	printf("%d\n", cnt);
	return 0;
}