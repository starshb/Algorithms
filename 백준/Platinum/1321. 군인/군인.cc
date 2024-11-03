#include <bits/stdc++.h>
#define rep(i,n) for(int i=0;i<n;++i)
#define REP(i,n) for(int i=1;i<=n;++i)
#define FAST cin.tie(NULL);cout.tie(NULL); ios::sync_with_stdio(false)
using namespace std;

const int MAXS = 500'000;


int N,x,Q,a,b,c;
int fenwick[MAXS + 1];

void update(int idx, int val) {
    while (idx <= N) {
        fenwick[idx] += val;
        idx += idx & -idx;
    }
}

int query(int idx) {
    int ret = 0;
    while (idx) {
        ret += fenwick[idx];
        idx -= idx & -idx;
    }
    return ret;
}

int main() {
    FAST;
    cin >> N;
    REP(i, N) {
        cin >> x;
        update(i, x);
    }
    cin >> Q;
    while (Q--) {
        cin >> a;
        if (a == 1) {
            cin >> b >> c;
            update(b, c);
        }
        else {
            cin >> b;
            int lo = 1;
            int hi = N;
            int best;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (query(mid) >= b) {
                    best = mid;
                    hi = mid - 1;
                }
                else lo = mid + 1;
            }
            cout << best << '\n';
        }
    }

    return 0;
}