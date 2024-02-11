import java.util.*;

class Solution {
    Set<Integer> original, additional;
    public int solution(int coin, int[] cards) {
        int answer = 0;
        int len = cards.length;
        original = new HashSet();
        additional = new HashSet();
        
        int idx = len / 3;
        for(int i = 0 ; i < idx; ++i)
            original.add(cards[i]);
        
        int target = len + 1;   
        while(true){
            answer++;
            if(idx >= len){
                break;
            }
            additional.add(cards[idx]);
            additional.add(cards[idx+1]);
            idx += 2;
            boolean flag = false;
            // Step1. 최초 카드에서 해결할 수 있는지 확인.
            for(int i : original){
                if(original.contains(target - i)){
                    original.remove(i);
                    original.remove(target - i);
                    flag = true;
                    break;
                }
            }
            
            // Step2. 최초 카드에서 해결이 안되었다면
            if(!flag){
                // 최초 카드와 라운드 추가 카드 1장을 이용해서 해결 할 수 있는지 확인.
                if(coin > 0){ // 최소 1개 이상의 코인이 있어야 추가 카드를 받아서 사용할 수 있다.
                    for(int i : original){
                        if(additional.contains(target - i)){
                            original.remove(i);
                            additional.remove(target - i);
                            --coin;
                            flag = true;
                            break;
                        }
                    }
                }
            }
            
            // Step3. 그래도 해결이 안되었다면, 추가 카드들 간에 해결이 가능한 지 확인.
            if(!flag){
                if(coin > 1){ // 최소 2개 이상의 코인이 있어야 추가 카드를 중에서 해결이 가능하다.
                    for(int i : additional){
                        if(additional.contains(target - i)){
                            additional.remove(i);
                            additional.remove(target - i);
                            coin -= 2;
                            flag = true;
                            break;
                        }
                    }
                }
            }
            
            // 완성되지 않았다.
            if(!flag)
                break;
        }
        return answer;
    }
}