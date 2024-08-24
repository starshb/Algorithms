#include <iostream>
#include <vector>
#include <algorithm>
#define pii pair<int, int>
 
using namespace std;
 
int N;
vector<int> Eucircuit;
 
vector<int> adj[1001];
vector<pii > edge;
int edgenum[1000001];
int edgecount;
 
void findEuler(int now){
    while(adj[now].size()){
        int e = adj[now].back();
        int u = edge[e].first;
        int v = edge[e].second;
        if(u > v) swap(u, v);
        if(edgenum[e]){
            edgenum[e]--;
            if(u == now) findEuler(v);
            else findEuler(u);
        }
        else adj[now].pop_back();
    }
    Eucircuit.push_back(now);
}
 
bool input(){
    cin >> N;
    int a;
    for(int i = 1; i <= N; i++){
        int degree = 0;
        for(int j = 1; j <= N; j++){
            cin >> a;
            degree += a;
            if(i >= j || !a) continue;
            edge.push_back({i, j});
            edgenum[edgecount] += a;
            
            adj[i].push_back(edgecount);
            adj[j].push_back(edgecount++);
        }
        if(degree % 2) return false;
    }
    return true;
}
 
int main(){
    ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    if(!input()){
        cout << -1;
        return 0;
    }
    
    findEuler(1);
    reverse(Eucircuit.begin(), Eucircuit.end());
    
    for(auto &w : Eucircuit){
        cout << w << " ";
    }
    
    return 0;
}