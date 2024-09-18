#include <iostream>
#include <algorithm>

using namespace std;

int main(void){
    int N, M, max = 0, idx;
    scanf("%d %d", &N, &M);
    int * arr = new int[M];

    for(int i=0; i<M; i++){
        scanf("%d", &arr[i]);
    }

    sort(arr, arr + M, greater<int>()); // 내림차순 정렬 (큰수 ~ 작은수)

    for(int i=0; i<M; i++){
        if(i < N){ // 1명 당 1개씩, N개 이상의 달걀은 팔 수 없음
            if(arr[i] * (i+1) > max){ // 인덱스 크기만큼의 사람이 달갈을 살 수 있음 (역순)
                max = arr[i] * (i+1);
                idx = i;
            }
        } else {
            break;
        }
    }

    printf("%d %d", arr[idx], max);

    return 0;
}