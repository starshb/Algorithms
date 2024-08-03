#include <iostream>
using namespace std;

#define str string
#define sz size
int k,n,a;

bool check(str s) {
    int n = s.sz();
    for (int i=1;;i++) {
        if (n-i*k<0) return 1;
        str t = s.substr(n-i,i);
        int j;
        for (j=1;j<=k;j++)
            if (s.substr(n-i*j,i)!=t)
                break;
        if (j==k+1) return 0;
    }
}

bool rec(str s) {
    if (s.sz()==n) {
        cout<<s;
        return 1;
    }
    for (char i='A';i<a+'A';i++)
        if (check(s+i))
            if (rec(s+i))
                return 1;
    return 0;
}

int main() {
    cin>>k>>n>>a;
    str s;
    if (!rec(s))
        cout<<-1;
}