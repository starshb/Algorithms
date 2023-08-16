class Solution {
    public int[] solution(String myString) {
        String[] splitArr = myString.split("x", myString.length());
        int[] answer = new int[splitArr.length];
        
        for (int i = 0; i < splitArr.length; i++) {
            answer[i] = splitArr[i].length();
        }
        return answer;
    }
}