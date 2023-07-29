class Solution {
    public int solution(int[] num_list) {
        String oddS = "";
        String evenS = "";
        for(int i=0; i<num_list.length; i++){
            if(num_list[i]%2==0){
                evenS += Integer.toString(num_list[i]);
            }else{
                oddS += Integer.toString(num_list[i]);
            }
        }
        int oddSum = Integer.parseInt(oddS);
        int evenSum = Integer.parseInt(evenS);
        
        return oddSum + evenSum;
    }
}