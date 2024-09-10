#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include <string>

using namespace std;
int arr[1001];
int dp[1000001];
const int INF=123456789;

int main() {
    ios::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
    
    int N;
    cin >> N;
  
    arr[1] = 1;
    int idx;


    fill(&dp[0], &dp[1000001], -1);

    for (int i = 2; i <= 1000; i++) {
        arr[i] = arr[i - 1] + 4 * i - 3;
        if (arr[i] >= 1000000)break;
        dp[arr[i]] = 1;
    }


    dp[1] = 1;
    for (int i = 2; i <= N; i++) {
        int val = INF;
        
        for (int j = 1; j <= 1000; j++) {
            if (val == 1 || val == 2)break;
            if (i < arr[j])break;
            if (i == arr[j])val = min(val,1);
            else {
                val = min(val,dp[i - arr[j]] + 1);
            }
        }
        dp[i] = val;
    }

    cout << dp[N];

    
}