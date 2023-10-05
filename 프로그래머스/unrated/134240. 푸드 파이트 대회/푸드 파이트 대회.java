class Solution {
    public String solution(int[] food) {
        // 음식을 순서대로 담을 StringBuilder 선언
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < food.length; i++) {
            // i번 음식을 2로 나눈 개수만큼 StringBuilder에 추가
            int count = food[i] / 2;
            sb.append(String.valueOf(i).repeat(count));
        }
        
        // StringBuilder에 추가된 음식에 0과 reverse된 문자열 더하기
        String answer = sb + "0";
        answer += sb.reverse();
        
        return answer;
    }
}