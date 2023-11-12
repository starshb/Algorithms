class Solution {
    int count = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers, 0, target, 0);
        answer = count;
        
        return answer;
    }
    public void dfs(int[] numbers, int depth, int target, int result){
        if (depth == numbers.length){ //마지막 노드까지 진행했을 때
            if (target == result){ //target값과 합계가 같다면
                count++;
            }
            return;
        }
        
        int plus = result + numbers[depth]; //양수를 더한 값
        int minus = result - numbers[depth]; //음수를 더한 값
        
        dfs(numbers, depth+1, target, plus);
        dfs(numbers, depth+1, target, minus);
        
    }
    
}