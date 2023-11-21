import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        char[] carr = s.toCharArray();
        Stack<Character> stack = new Stack<>();   
    
        for (int i=0;i<carr.length;i++) {
            char c = carr[i];
            // 스택이 비어있다면 현재 문자는 반복될 일이 없으므로 push
            if (stack.isEmpty()) stack.push(c);
            // 스택이 비어있지 않다면
            else {
                // 스택의 top확인(peek) - 만약 현재 문자와 같다면 반복이므로 스택에서 pop하고 현재 문자도 스택에 넣지 않음
                // 이렇게 되면 스택에는 반복이 발생하는 이전문자와 현재문자 모두 들어가지 않게 됨 (반복제거)
                if (stack.peek() == c) {
                    stack.pop();
                // 스택의 top이 현재 문자와 다르다면 반복이 아니므로 push
                } else {
                    stack.push(c);
                }
            }
        }        
        // 스택에 남아있는 값들은 반복되지 않는 값들임 즉, 비어있어다면 모두 짝지어 반복된 것
        return stack.isEmpty() ? 1 : 0;
    }
}