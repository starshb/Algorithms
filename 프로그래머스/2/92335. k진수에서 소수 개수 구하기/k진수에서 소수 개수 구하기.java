import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String temp="";
        
//N진법 변환
        while(n!=0){          
            temp=n%k+temp;
            n/=k;
        }

        String[] arr = temp.split("0");
        
        for(String data: arr){
            if(data.equals("")) continue;
            long num=Long.parseLong(data);                       
            if(isPrime(num)){
                answer++;
            }
        }
        
        return answer;
    }
    
//소수확인 메소드
    public boolean isPrime (long a){
        
        if(a<2) return false;
        
        for(int i=2;i<=Math.sqrt(a);i++){
            if(a%i==0){
                return false;
            }
        }
        return true;
    }
}
