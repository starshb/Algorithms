class Solution {
    public String[] solution(String[] picture, int k) {
        int rows = picture.length;
        int cols = picture[0].length();

        int newRows = rows * k;
        int newCols = cols * k;

        String[] newPicture = new String[newRows];

        for (int i = 0; i < newRows; i++) {
            StringBuilder sb = new StringBuilder();
            int row = i / k;

            for (int j = 0; j < newCols; j++) {
                int col = j / k;
                char pixel = picture[row].charAt(col);
                sb.append(pixel);
            }

            newPicture[i] = sb.toString();
        }

        return newPicture;
    }
}