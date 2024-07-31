#include<bits/stdc++.h>
#define f(i,l,r) for(int i=l;i<=r;++i)
#define update(a,b) a=max(a,b)
using namespace std;

const int MAXH=25e4;
int n,h,s[2][MAXH+1],val,i;

int main(){
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	memset(s,-1,sizeof(s));
	s[0][0]=0;

	cin>>n;
	while(n--){
		cin>>h;
		int ni=i^1;
		f(j,0,MAXH)if((val=s[i][j])>=0){
			int a=j+h,b=abs(j-h);
			update(s[ni][j],val);				// 1
			if(a<=MAXH)update(s[ni][a],val+h);		// 2
			if(b<=MAXH)update(s[ni][b],val+(j<h?b:0));	// 3
		}
		i=ni;
	}

	cout<<(s[i][0]>0?s[i][0]:-1);
	return 0;
}
