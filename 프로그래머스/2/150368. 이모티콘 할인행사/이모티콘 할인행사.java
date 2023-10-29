class Solution {
    
int sign=0;
int earn=0;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int [2];
        
        int[] arr =new int[emoticons.length];
        
        comb(arr,0,users,emoticons);
        
        answer[0]=sign;
        answer[1]=earn;
        
        return answer;
    }
    
    public void comb(int[] arr,int start,int[][] users,int[] emoticons){
        
        if(start==arr.length){
            calculate(arr,users,emoticons);
            return;
        }
        
        for(int i=10;i<=40;i+=10){
            arr[start]=i;
            comb(arr,start+1,users,emoticons);
        }
        
    }
    
    public void calculate(int[] arr,int[][] users,int[] emoticons){
        
        int count=0;
        int earn_t=0;
        
        for(int[] user:users){
            int discount= user[0];
            int price =user[1];
            int sum=0;
            
            for(int i=0;i<arr.length;i++){
                if(arr[i]>=discount){
                    sum+=(emoticons[i]/100)*(100-arr[i]);
                }
            }
            
            if(sum>=price){
                count++;
            }
            else{
                earn_t+=sum;
            }  
        }
        
        
        if(count>sign){
            sign=count;
            earn=earn_t;
            return;
        }    
        else if(count==sign){
            if(earn<earn_t){
                earn=earn_t;
            }
        }
    }
    
}
