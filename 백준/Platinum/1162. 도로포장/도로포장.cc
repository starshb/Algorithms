#include <cstdio>
#include <vector>
#include <iostream>
#include <queue>
using namespace std;

int n, m, k;
long long int cost[10001][21];
vector<pair<int, int>> way[10001]; //pos, cost
priority_queue<pair<long long, pair<int, int>>> pq; //cost,pos,포장

long long int dijkstra(int start){
    int here, there;
    long long int here_c;
    long long int there_c;
    long long int min_c = -1;

    for(int j=1; j<=n; j++){
        for (int i=0; i<21; i++)
            cost[j][i] = -1;
    }
    
    cost[start][0] = 0;
    pq.push(make_pair(-0, make_pair(start, 0)));
    
    while(!pq.empty()){
        here_c = -pq.top().first;
        here = pq.top().second.first;
        int cnt = pq.top().second.second;
        pq.pop();
        
        if(here_c> cost[here][cnt])
            continue;
        
        for(int j=0; j<way[here].size(); j++){
            
            there = way[here][j].first;
            there_c = here_c + way[here][j].second;
            
            if (cnt < k) //포장O -> 이동 비용이 0
            {
                if(cost[there][cnt+1] == -1) {
                    cost[there][cnt+1] = here_c;
                    pq.push(make_pair(-here_c, make_pair(there, cnt+1)));
                }
                if (cost[there][cnt+1] > here_c) {
                    cost[there][cnt+1] = here_c;
                    pq.push(make_pair(-here_c, make_pair(there, cnt+1)));
                }
            }
            
            
            if (cost[there][cnt] > there_c || cost[there][cnt] == -1) //포장X -> 이동비용이 있음!
            {
                cost[there][cnt] = there_c;
                pq.push(make_pair(-there_c, make_pair(there, cnt)));
            }
            
            
        }
    }
    min_c = cost[n][0];
    
    for(int i=1; i<=k; i++){
        if(min_c > cost[n][i] && cost[n][i] != -1)
            min_c = cost[n][i];
    }
    return min_c;
}




int main (void){

    int a, b, cost;
    scanf("%d %d %d", &n, &m, &k);
  
    for (int i=1; i<=m; i++){
        scanf("%d %d %d", &a, &b, &cost);
        way[a].push_back(make_pair(b, cost));
        way[b].push_back(make_pair(a, cost));
    }
    

    printf("%lld\n",dijkstra(1));
    
}