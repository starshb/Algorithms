#include <cstdio>
#include <cstring>
#include <vector>
#include <algorithm>
using namespace std;

struct que{
    int x, y, c;
    que(int x, int y, int c) :x(x), y(y), c(c){}
};
vector<que> a;
int n;
bool visited[101];
int dp[1001][1001];

int rpg(int STR, int INT){
	int &ret = dp[STR][INT];
	if(ret != -1) return ret;

	ret = 0;
	int pnt = 0;
	vector<int> Q;
	for(int i = 0; i < n; i++){
        if(a[i].x <= STR || a[i].y <= INT){
            ret++;
            if(!visited[i]){
                visited[i] = true;
                pnt += a[i].c;
                Q.push_back(i);
            }
        }
	}

	for(int p = 0; p <= pnt; p++){
        int nextSTR = min(1000, STR + p);
        int nextINT = min(1000, INT + pnt - p);
        ret = max(ret, rpg(nextSTR, nextINT));
	}
	for(int q : Q)
        visited[q] = false;

	return ret;
}

int main(){
	scanf("%d", &n);
	for(int i=0; i<n; i++){
        int STR, INT, PNT;
		scanf("%d %d %d", &STR, &INT, &PNT);
        a.push_back(que(STR, INT, PNT));
	}
	memset(dp, -1, sizeof(dp));
	printf("%d\n", rpg(1, 1));
}


