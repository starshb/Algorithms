import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        //1, 4, 7 - L
        // 3, 6, 9 - R
        String answer = "";
        int left = 10; //*
        int right = 12; //#
        
        for(int num : numbers) {
            if(num==1 || num==4 || num==7) {
                left = num;
                answer += "L";
            } else if(num==3 || num==6 || num==9) {
                right = num;
                answer += "R";
            } else {
                if(num == 0) {
                    num = 11;
                }
                
                int leftDist = Math.abs(num-left)/3 + Math.abs(num-left)%3;
                int rightDist = Math.abs(num-right)/3 + Math.abs(num-right)%3;
                
                if(leftDist<rightDist) {
                    answer += "L";
                    left = num;
                } else if(leftDist>rightDist) {
                    answer +="R";
                    right = num;
                } else {
                    if(hand.equals("left")) {
                        answer += "L";
                        left = num;
                    } else {
                        answer +="R";
                        right = num;
                    }
                }
            }
        }
        return answer;
    }
}