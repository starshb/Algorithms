class Solution {
    public int solution(String my_string) {
        String[] arr = my_string.split("\\s");              //my_string을 공백을 기준으로 split
        int answer = Integer.parseInt(arr[0]);              //arr의 첫번째 값으로 식을 시작
        
        for (int i = 1; i < arr.length; i += 2) {           //arr의 홀수번째 값은 사칙연산 기호임
            if (arr[i].equals("+")) {
                answer += Integer.parseInt(arr[i + 1]);     //arr의 짝수번째 값은 정수임
            } else {
                answer -= Integer.parseInt(arr[i + 1]);
            }
        }
        return answer;
    }
}
