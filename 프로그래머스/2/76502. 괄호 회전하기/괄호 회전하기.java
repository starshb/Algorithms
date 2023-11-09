import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // 다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의
        
        // 만약 A가 올바른 괄호 문자열이라면 (A), [A], {A} 도 올바른 괄호 문자열
        // 예를 들어, [] 가 올바른 괄호 문자열이므로, ([]) 도 올바른 괄호 문자열입니다.
        
        // 만약 A,B 가 올바른 괄호 문자열이라면 AB도 올바른 괄호 문자열입니다. 
        // 예를 들어, {}와 ([]) 가 올바른 괄호 문자열이므로 {}([])도 올바른 괄호 문자열입니다.
        
        // 대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 S가 매개변수로 주어진다
        // 이 s를 왼쪽으로 x칸만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수를 
        // return 하도록 solution 함수를 완성
        
        // [](){} -> 3
        
        // }]()[{
                
        Queue<String> queue = new LinkedList<>();
        
        for(int i = 0; i < s.length(); i++){
            String str = s.substring(i,i+1);
            queue.add(str);
        }
        
        
        for(int i = 0; i < s.length(); i++){
            String firstStr = queue.poll();
            queue.add(firstStr);
            
            Stack<String> stack = new Stack<>();
            
            // stack에 전부 넣기
            for(int j = 0; j < s.length(); j++){
                String waitingStr = queue.poll();
                queue.add(waitingStr);
                
                if(stack.isEmpty()){
                    stack.push(waitingStr);
                } 
                else if(waitingStr.equals(")") && stack.peek().equals("(")){
                    stack.pop();
                }
                else if(waitingStr.equals("]") && stack.peek().equals("[")){
                    stack.pop();
                }
                else if(waitingStr.equals("}") && stack.peek().equals("{")){
                    stack.pop();
                }
                else{
                    stack.push(waitingStr);
                }
                
            }
            
            if(stack.isEmpty()){
                answer++;
            }
            
        }
        
        return answer;
    }
}