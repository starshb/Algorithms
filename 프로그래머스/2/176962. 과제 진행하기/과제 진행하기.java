import java.util.*;
class Task {
    int index;
    int start;
    int playtime;
    public Task(int index, int start, int playtime) {
        this.index = index;
        this.start = start;
        this.playtime = playtime;
    }
}
class Solution {
    public int getTime(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
    }
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Arrays.sort(plans, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });
        Stack<Task> ing = new Stack();
        ArrayList<String> end = new ArrayList<>();        
        for(int i = 0; i < plans.length; i++) {
            int start = getTime(plans[i][1]);
            int playtime = Integer.parseInt(plans[i][2]);
            if(ing.isEmpty()) {
                ing.push(new Task(i, start, playtime));
                continue;
            }
            Task now = ing.pop();
            if(now.start + now.playtime > start) { //하던거 스택에 넣고 지금꺼 푸시
                ing.push(new Task(now.index, start, now.playtime - (start - now.start))); //하던거 다시 넣고
            } else {
                end.add(plans[now.index][0]);
                //남는 시간에 ing 스택에 있는것들 해주기
                int remain = start - (now.start + now.playtime);
                while(remain > 0 && !ing.isEmpty()) {
                    int del = ing.peek().playtime - remain;
                    ing.peek().playtime = Math.max(0, del);
                    
                    if(del <= 0)
                    {
                        remain = -1 * del;
                        end.add(plans[ing.pop().index][0]);
                    }else {
                        remain = 0;
                    }
                }
            }
            ing.push(new Task(i, start, playtime)); //새로운거 푸시            
        }
        int k;
        for(k = 0; k < end.size(); k++)
            answer[k] = end.get(k);
        while(!ing.isEmpty())
        {
            answer[k++] = plans[ing.pop().index][0];
        }
        return answer;
    }
}