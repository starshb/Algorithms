class Solution {
    public String solution(String my_string, int n) {
        String str = "";
        String[] arr = my_string.split("");
        for(int i=0; i<my_string.length(); i++){
            str += arr[i].repeat(n);
        }
        return str;
    }
}