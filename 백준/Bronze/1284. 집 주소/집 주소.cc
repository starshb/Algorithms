#include <iostream>
#define endl "\n"

using namespace std;

int main(){
    string s;
    while(cin>>s){
        if(s == "0"){
            break;
        }
        int answer = 1;
        for(int i = 0;i<s.size();i++){
            if(s[i] == '1'){
                answer += 3;
            }
            else if(s[i] == '0'){
                answer += 5;
            }
            else {
                answer += 4;
            }
        }
        cout<<answer<<endl;

    }

    return 0;
}