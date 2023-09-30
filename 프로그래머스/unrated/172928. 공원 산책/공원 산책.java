import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int x = -1;  //시작지점이자 최종 위치
        int y = -1;  //시작지점이자 최종 위치
        int height = park.length;   //공원 높이
        int weight = park[0].length();    //공원 넓이
        
        //공원 순회
        for(int i=0;i<park.length;i++){
            if(park[i].indexOf('S') != -1){
                x = park[i].indexOf('S');
                y = i;
                break;
            }
        }
        
        
        
        // 강아지 명령 순회
        for(int i=0;i<routes.length;i++){
            String[] temp = routes[i].split(" ");
            String vector = temp[0];        //방향
            int distance =  Integer.parseInt(temp[1]);  //거리
            int currX = x;
            int currY = y;
            
            if(vector.equals("E")){ //동
                boolean flag = true;
                for(int j=1;j<=distance;j++){
                    currX++;
                    if(currX >= weight){	//범위를 벗어났나
                        flag = false;
                        break;
                    }
                    // 장애물이 있나
                    else if(park[currY].charAt(currX) =='X'){
                        flag = false;
                        break;
                    }
                    
                }
                if (flag) {
                    x = currX;
                }
            }
            else if(vector.equals("W")){    //서
                boolean flag = true;
                for(int j=1;j<=distance;j++){
                    currX--;
                    if(currX < 0){
                        flag = false;
                        break;
                    }
                    else if(park[currY].charAt(currX) =='X'){
                        flag = false;
                        break;
                    }
                    
                }
                if (flag) {
                        x = currX;
                }
            }
            else if(vector.equals("S")){    //남
                boolean flag = true;
                for(int j=1;j<=distance;j++){
                    currY++;
                    if(currY >= height){
                        flag = false;
                        break;
                    }
                    else if(park[currY].charAt(currX) =='X'){
                        flag = false;
                        break;
                    }
                    
                }
                if (flag) {
                        y = currY;
                }
            }
            else if(vector.equals("N")){    //북
                boolean flag = true;
                for(int j=1;j<=distance;j++){
                    currY--;
                    if(currY < 0){
                        flag = false;
                        break;
                    }
                    else if(park[currY].charAt(currX) =='X'){
                        flag = false;
                        break;
                    }
                    
                }
                if (flag) {
                    y = currY;
                }
            }

        }
        
        answer[0] = y;
        answer[1] = x;
        
        return answer;
    }
}