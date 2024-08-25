#include<cstdio>
#include<vector>
#include<algorithm>
using namespace std;
const int MAX_N = 50;
using ll = long long;
ll psw[MAX_N], psc[MAX_N];
int N;
vector<pair<ll, ll>> items;
ll rec(int p, ll C, bool usedBig) {
    if (p < 0) return 0;
    if (psw[p] <= C) return psc[p];
    else if (items[p].first <= C && (usedBig || items[p + 1].first != items[p].first))
        return max(rec(p - 1, C - items[p].first, 1) + items[p].second, rec(p - 1, C, 0));
    else return rec(p - 1, C, 0);
}
int main() {
    int T, i;
    ll C;
    scanf("%d", &N);
    items.resize(N);
    for (i = 0; i < N; i++)
        scanf("%lld%lld", &items[i].first, &items[i].second);
    sort(items.begin(), items.end());
    psw[0] = items[0].first, psc[0] = items[0].second;
    for (i = 1; i < N; i++)
        psw[i] = psw[i - 1] + items[i].first, psc[i] = psc[i - 1] + items[i].second;
    scanf("%lld", &C);
    printf("%lld\n", rec(N - 1, C, 1));
    return 0;
}