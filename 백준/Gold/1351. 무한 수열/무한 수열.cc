#include <iostream>
#include <unordered_map>

using namespace std;

long long N,P,Q;
unordered_map<long long, long long> m;

long long solve(long long num){
    long long ret;
    if(m.find(num) != m.end()){
        return m[num];
    }
    ret = solve(num/P) + solve(num/Q);
    m[num] = ret;
    return ret;
}

int main (){
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> N >> P >> Q;
    m[0] = 1;
    if(N == 0)
        cout << 1;
    else
        cout << solve(N/P) + solve(N/Q);
    
}