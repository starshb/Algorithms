import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        // 1. 연속된 인형들이 제거된 횟수.
        int answer = 0;
        // 2. 인형을 담을 stack 바구니.
        Stack<Integer> stack = new Stack<>();       
        
        // 3. moves의 크기는 크레인의 총 이동횟수.
        for(int i =0;i<moves.length;i++){
            // 3-1. j 인덱스를 이용해 보드의 행을 탐색. 열은 moves의 원소를 이용해 탐색.
            for(int j=0;j<board.length;j++){
                // 3-2. j행의 moves의 크레인위치 열에 해당하는 값에 인형이 존재한다면.
                if(board[j][moves[i]-1] != 0 ) {                   
                    // 3-3. stack이 비어있지 않고, 현재 스택의 최상단에 있는 인형과 크레인으로 뽑은 인형이 같다면
                    if(!stack.empty() && stack.peek() == board[j][moves[i]-1]){
                        // 인형들을 제거하는 횟수 증가.
                        answer++;
                        // 바구니에 있는 인형을 제거.
                        stack.pop();
                        // 크레인으로 뽑은 인형을 0으로 만들어 없애준다.
                        board[j][moves[i]-1] = 0;
                        break;
                    // 3-4. 그 외의 경우는 인형을 바구니에 담은 후 0으로 없애준다.    
                    }else{
                        stack.push(board[j][moves[i]-1]);                      
                        board[j][moves[i]-1] = 0;
                        break;
                    }
                }                        
            }
        }
        
       
        // 4. 없앤 인형의 수 = 인형을 없앤 수 * 2.
        return answer*2;
    }
}