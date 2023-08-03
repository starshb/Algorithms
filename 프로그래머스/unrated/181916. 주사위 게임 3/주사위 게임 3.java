import java.util.Arrays;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] nums=new int[4];
        nums[0]=a;
        nums[1]=b;
        nums[2]=c;
        nums[3]=d;
        
        int multi=1;
        
        Arrays.sort(nums);//오름차순 정렬
        int[] dice=new int[6];
        for(int i=0;i<4;i++){
            dice[nums[i]-1]++;
        }
        
        for(int i=0;i<6;i++){
            if(dice[i]==4){
                answer=1111*(i+1);
                break;
            }
            else if(dice[i]==3){
                for(int j=0;j<6;j++){
                    if(dice[j]==1){
                        answer=(10*(i+1)+(j+1))*(10*(i+1)+(j+1));
                        break;
                    }
                }
            }
            else if(dice[i]==2){
               for(int j=0;j<6;j++){
                    if(dice[j]==2){
                        if(i==j){
                            continue;
                        }
                        else{
                            answer=(i+1+j+1)*((i+1)-(j+1));
                            break;
                        }
                        
                    }
                   else if(dice[j]==1){
                        multi=multi*(j+1);
                   }
                }
                if(multi!=1){
                    answer=multi;
                }
            }
            if(nums[0]!=nums[1] && nums[1]!=nums[2] && nums[2]!=nums[3]){
                answer=nums[0];
            }
                
        }
        
        return answer;
    }
}