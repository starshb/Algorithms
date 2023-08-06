import java.util.Arrays;

class Solution {
    public String solution(String my_string, int[] indices) {
        Arrays.sort(indices);
        StringBuilder sb = new StringBuilder(my_string);
        for (int i = indices.length - 1; i >= 0; i--) {
            int index = indices[i];
            if (index < sb.length()) {
                sb.deleteCharAt(index);
            }
        }
        return sb.toString();
    }
}