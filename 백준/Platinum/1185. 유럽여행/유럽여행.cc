#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int country_num, path_num;
int country_cost[10001];
vector<pair<int,int>> adj[10001];

class DisjointSet{  // Union find 구현
  public:
  vector<int> parent, rank;

  DisjointSet(int n): parent(n), rank(n){
    for(int i=0; i<parent.size() ; ++i) //초기는 자신이 루트
      parent[i] = i;
  }

  int Find(int u){
    if(parent[u] == u)
      return u;
    return parent[u] = Find(parent[u]);
  }

  void Union(int u, int v){
    u = Find(u); v = Find(v);
    if(u == v)
      return;

    if(rank[v] < rank[u]) //rank는 항상 v가 크게 유지
      swap(u,v);  

    parent[u] = v;  //u를 v의 하위로 Union
    if(rank[u] == rank[v])
      rank[v]++;

    return;
  }
};

struct PathInfo{
  int u, v, cost;
  
  bool operator<(const PathInfo& x){
    return cost < x.cost;
  }
};

int Kruskal(){
  int min_spanning = 0;
  vector<PathInfo> edges;

  int u, v, cost;
  for(int u=1 ; u<=country_num  ; ++u)
    for(int i=0; i<adj[u].size() ; ++i){
      v = adj[u][i].first;
      cost = adj[u][i].second;

      edges.push_back({u, v, cost});
    }

  sort(edges.begin() , edges.end());

  DisjointSet sets(country_num+1);
  int union_cnt =0;
  for(int i=0 ; i<edges.size() ; ++i){
    u = edges[i].u; v = edges[i].v;
    cost = edges[i].cost;

    if(sets.Find(u) == sets.Find(v))
      continue;

    sets.Union(u, v);
    ++union_cnt;
    min_spanning += cost;

    if(union_cnt == country_num -1) //모든 정점이 union된 경우
      break;
  }

  return min_spanning;
}

int main(){
  ios_base::sync_with_stdio(0);
  cin>>country_num>>path_num;

  int min_country_cost = 1001;  
  for(int i=1; i<=country_num ; ++i){
    cin>>country_cost[i];
    min_country_cost = min(min_country_cost, country_cost[i]);
  }

  int u, v, weight, cost;
  for(int i=0; i<path_num ; ++i){
    cin>>u>>v>>weight;
    cost = 2*weight + country_cost[u] + country_cost[v];
    adj[u].push_back({v,cost});
  }

  int min_spanning = Kruskal();

  int answer = min_spanning + min_country_cost;
  cout<<answer<<'\n';

  return 0;
}