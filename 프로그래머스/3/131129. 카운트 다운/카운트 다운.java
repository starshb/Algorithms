class Solution {
    int[][] dp;
    public int[] solution(int target) {
        int[] answer = new int[2];
        //최선의 경우 던질 다트 수, 그때의 싱글/불을 맞춘 횟수의 합
        
        //점수, 던진 횟수, 싱글/볼을 맞춘 횟수
        //dp[i][0] = c, 점수: i, 던진 횟수: c
        //dp[i][1] = s, 싱글/불 맞춘 횟수: s
        
        dp = new int[target+1][2];
        for(int i=0; i<=target; i++){
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = 0;
        }
        
        dp[0][0] = 0;
        for(int i=1; i<=target; i++){ 
            for(int j=1; j<=20; j++){ 
                int b_or_s = -1;
                //불을 쏘는 경우
                if(i-50>=0){
                    if(dp[i][0] > dp[i-50][0]+1){ //더 적게 던지는 경우로 갱신
                        dp[i][0] = dp[i-50][0]+1;
                        dp[i][1] = dp[i-50][1]+1;
                    }
                    else if(dp[i][0] == dp[i-50][0]+1){ //같은 다트 수라면, 불/싱글을 더 많이 쏘는 경우로 갱신
                        dp[i][1] = Math.max(dp[i][1], dp[i-50][1]+1); 
                    }
                    
                }
                
                //싱글을 쏘는 경우
                if(i-j>=0){
                    if(dp[i][0] > dp[i-j][0]+1){
                        dp[i][0] = dp[i-j][0]+1;
                        dp[i][1] = dp[i-j][1]+1;
                    }
                    else if(dp[i][0] == dp[i-j][0]+1){ //같은 다트 수라면, 불/싱글을 더 많이 쏘는 경우로 갱신
                        dp[i][1] = Math.max(dp[i][1], dp[i-j][1]+1); 
                    }
                }
                
                //더블을 쏘는 경우
                if(i-2*j>=0){
                    if(dp[i][0] > dp[i-2*j][0]+1){
                        dp[i][0] = dp[i-2*j][0]+1;
                        dp[i][1] = dp[i-2*j][1];
                    }
                    
                }
                
                //트리플을 쏘는 경우
                if(i-3*j>=0){
                    if(dp[i][0] > dp[i-3*j][0]+1){
                        dp[i][0] = dp[i-3*j][0]+1; 
                        dp[i][1] = dp[i-3*j][1];
                    }
                }

            
            }
        }
        
        //다트 수, 싱글/불 횟수
        answer[0] = dp[target][0];
        answer[1] = dp[target][1];
        
        return answer;
    }
}