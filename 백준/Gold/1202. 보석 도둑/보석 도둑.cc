#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

#define MAX 300001
using namespace std;

int N; // 보석 수
int K; // 가방수


pair<int, int> v_jewerly[MAX];
int v_bag[MAX];
priority_queue<int, vector<int>, less<int>> pq;


long long solve() {
    sort(v_jewerly, v_jewerly+N);
    sort(v_bag, v_bag+K);

    int idx = 0;
    long long sum = 0;

    for (int i = 0; i < K; i++) {
        while (idx < N && v_bag[i] >= v_jewerly[idx].first) {
            pq.push(v_jewerly[idx].second);
            idx++;
        }
        if (!pq.empty()) {
            sum += pq.top();
            pq.pop();
        }
    }
    return sum;
}

int main() {
    cin >> N >> K;
    for (int i = 0; i < N; ++i) {
        cin >> v_jewerly[i].first >> v_jewerly[i].second;
    }
    for (int i = 0; i < K; ++i) {
        cin >> v_bag[i];
    }
    cout << solve();
}
