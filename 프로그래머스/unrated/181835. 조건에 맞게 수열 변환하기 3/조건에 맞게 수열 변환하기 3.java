class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[arr.length];
        
        for(int i=0; i<arr.length; i++){
            if(k%2==0){
                answer[i]=arr[i]+k;
            }else{
                answer[i]=arr[i]*k;
            }
        }
        
        return answer;
    }
}