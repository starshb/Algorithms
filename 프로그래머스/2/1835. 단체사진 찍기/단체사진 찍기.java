import java.util.*;
class Solution {
    static char [] friends;
    static String [] dt;
    static int answer;
    static boolean [] visited;
    public int solution(int n, String[] data) {
        dt = data;
        answer = 0;
        friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        visited = new boolean[8];

        dfs("",0);
        return answer;
    }
    static void dfs(String line, int depth)
    {
        if(depth == 8)
        {
            if(check(line)) answer++;
            return;
        }

        // depth -> 자리(인덱스) , i -> 프렌즈
        for(int i = 0; i < 8; ++i)
        {
            //아직 줄을 서지 않은 프렌즈면 세우고 재귀
            if(!visited[i])
            {
                visited[i] = true;
                dfs(line+friends[i],depth+1);
                visited[i] = false;
            }
        }
    }
    static boolean check(String line)
    {
        //"N~F=0", "R~T<2"
        for(String cond : dt)
        {
            //둘사이의 거리
            int diff = (Math.abs(line.indexOf(cond.charAt(0)) - line.indexOf(cond.charAt(2))))-1;
            char sign = cond.charAt(3);
            int val = cond.charAt(4)-'0';

            if(sign == '=')
            {
                if(diff != val) return false;
            }
            else if(sign == '>')
            {
                if(diff <= val) return false;
            }
            else
            {
                if(diff >= val) return false;
            }
        }
        //걸리지지 않았다면 true
        return true;
    }
}