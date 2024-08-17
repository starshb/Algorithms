#include<iostream>
using namespace std;

int n, s;
int cnt;
bool isused[22];
int arr[22];
int sum;

void func(int nx,int x)
{
	//if (nx == n) return;	//isused로 점점 고려할 수열의 원소 수가 줄어들기 때문에 이 조건에는 어차피 한번밖에 걸리지 않는다 

	if (sum == s && nx != 0)		
	{
		cnt++;
		//return;	//return 하면 sum과 s 같아졌을때 그 이후 수열을 더하지 않고 return 해버린다
	}

	for (int i = 0 ; i < n; i++)
	{
		
		if (isused[i] || x>i) continue;		// 이미 합을 구했던 부분수열은 고려하지 않음

		isused[i] = true;
		sum += arr[i];
		func(nx + 1,i);

		isused[i] = false;
		sum -= arr[i];
	}
}

int main(void)
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> n >> s;
	for (int i = 0 ; i < n; i++)
		cin >> arr[i];

	func(0,0);

	cout << cnt;

	return 0;
}