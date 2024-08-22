#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <memory.h>
 
using namespace std;
int n, k, height[17];
int fullstate;
long long dp[1 << 17][17];            //dp[누구누구가 섰나?][마지막 사람은 누구?] : 해당 조합에서 가능한 경우의 수
 
void getDP() {
    //모든 State에 대해
    for (int i = 1; i <= fullstate; i++) {
        //각 State에서 마지막으로 j번이 설 수 있는 경우의 수를 체크한다.
        for (int j = 1; j <= n; j++) {
            //도달할 수 없는 Case 라면 건너뜀.
            if (dp[i][j] == 0) continue;
            //현재 State에서 m번을 세우는 것이 가능하다면, i상태의 j가 마지막인 경우의 수를 모두 m을 마지막으로 세운 새로운 State에 더해줌.
            for (int m = 1; m <= n; m++) {
                int newstate = i | 1 << (m - 1);
                if(!(i & 1 << (m - 1)) && abs(height[j] - height[m]) > k) dp[newstate][m] += dp[i][j];
            }
        }
    }
}
 
void init() {
    cin >> n >> k;
 
    memset(dp, 0, sizeof(dp));
 
    for (int i = 1; i <= n; i++) {
        int state = 1 << (i - 1);
        cin >> height[i];
        dp[state][i] = 1;
    }
    fullstate = (1 << n) - 1;
}
 
int main() {
    init();
 
    getDP();
 
    long long answer = 0;
    for (int i = 1; i <= n; i++) answer += dp[fullstate][i];
    
    printf("%lld\n", answer);
 
    //system("PAUSE");
    return 0;
}