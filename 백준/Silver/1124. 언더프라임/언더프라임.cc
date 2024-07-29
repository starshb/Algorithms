#include<iostream>
 
using namespace std;
 
int main(void){
    int A,B;
    cin>>A>>B;
 
    bool check[100002];
    fill_n(check,100002,true);
    check[1]=false; // 1과 0은 소수가 아님 !
    check[0]=false;
    int arr[100002]={0};
    int result=0;
 
    for(int i=2;i<=100000;i++){
        if(check[i]){ // 만약 i가 소수라면
            for(int j=i*2;j<=B;j+=i){ // i의 배수들을 찾아서
                check[j]=false; // 소수가 아님을 처리
                int curNum=j;
                while(curNum%i==0){
                    curNum/=i;
                    arr[j]++;
                } // 그리고 i로 나누어지는 횟수만큼 증가
            }
        }
    }
    for(int i=A;i<=B;i++){
        if(check[arr[i]]) result++;
    }
    cout<<result<<endl;
}
