#include <iostream>
#include <unordered_map>
using namespace std;

int main(void){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N,M;
    cin>>N;

    unordered_map<long long,int> war;
    
    long long maxNum=-1,maxFreq=0;
    long long num;

    while(N--){
        cin>>M;
        
        for(int j=0;j<M;j++){
            cin>>num;
            war[num]++; // 입력한 숫자에 대응하는 index 위치값 증가
            // num이 key이고 war[num]이 value인 셈
            if(war[num]>maxFreq){
                maxFreq=war[num];
                maxNum=num;
            } // maxFreq와 maxNum 업데이트
        }

        int halfM=M/2;
        if(maxFreq>halfM){
            cout<<maxNum<<'\n';
        }else{
            cout<<"SYJKGW"<<'\n';
        }
        war.clear();
        maxFreq=0;
        maxNum=-1;
    }
    return 0;
}