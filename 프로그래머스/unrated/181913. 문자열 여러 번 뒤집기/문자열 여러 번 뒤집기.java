class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] arr = my_string.toCharArray(); // 문자열을 문자 배열로 변환
        
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            
            while (start < end) {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                
                start++;
                end--;
            }
        }
        
        return new String(arr); // 문자 배열을 문자열로 변환하여 반환
    }
}