#include <cstdio>
#include <cstring>
using namespace std;
using ll = long long;
int N,a[6];
ll dp[7][7][11][11][11][11][11];
ll sol(int prev,int cur,int a,int b,int c,int d,int f){
    if(a==0&&b==0&&c==0&&d==0&&f==0) return 1;
    ll& ret=dp[prev][cur][a][b][c][d][f];
    if(ret!=-1) return ret;
    ret=0;
    if(a>0 && prev!=0 && cur!=0) ret+=sol(cur,0,a-1,b,c,d,f);
    if(b>0 && prev!=1 && cur!=1) ret+=sol(cur,1,a,b-1,c,d,f);
    if(c>0 && prev!=2 && cur!=2) ret+=sol(cur,2,a,b,c-1,d,f);
    if(d>0 && prev!=3 && cur!=3) ret+=sol(cur,3,a,b,c,d-1,f);
    if(f>0 && prev!=4 && cur!=4) ret+=sol(cur,4,a,b,c,d,f-1);
    return ret;
}
int main(){
    scanf("%d",&N);
    for(int i=0;i<N;i++) scanf("%d",&a[i]);
    memset(dp,-1,sizeof(dp));
    printf("%lld",sol(6,5,a[0],a[1],a[2],a[3],a[4]));
}