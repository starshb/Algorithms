class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        
        int my = my_string.length();	
        int over = overwrite_string.length();
        
        String sub_st_01 = my_string.substring(0, s);
        String sub_st_02 = my_string.substring((s+over), my);
        
        return answer = answer + sub_st_01 + overwrite_string + sub_st_02;
    }
}