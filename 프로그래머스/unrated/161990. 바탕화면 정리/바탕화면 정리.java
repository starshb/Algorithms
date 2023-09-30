class Solution {
    int gRow, gCol;
    int minRow, minCol;
    int maxRow, maxCol;
    char[][] gWallpaper;
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[] solution(String[] wallpaper) {
        minRow = minCol = Integer.MAX_VALUE;
        maxRow = maxCol = Integer.MIN_VALUE;

        gRow = wallpaper.length;
        gCol = wallpaper[0].length();
        gWallpaper = new char[gRow][gCol];

        int idx = 0;
        for (String str : wallpaper) {
            gWallpaper[idx] = str.toCharArray();
            idx++;
        }

        for (int r = 0; r < gRow; r++) {
            for (int c = 0; c < gCol; c++) {
                if (wallpaper[r].charAt(c) == '#') {
                    dfs(r, c);
                }
            }
        }

        //max 값에 + 1을 하는 이유는 드래그를 하려면 끝점을 선택해야 함
        return new int[]{minRow, minCol, maxRow + 1, maxCol + 1};
    }

    private void dfs(int r, int c) {
        if (r < minRow) {
            minRow = r;
        }
        if (r > maxRow) {
            maxRow = r;
        }
        if (c < minCol) {
            minCol = c;
        }
        if (c > maxCol) {
            maxCol = c;
        }

        gWallpaper[r][c] = '!';

        for (int[] direction : directions) {
            int newR = r + direction[0];
            int newC = c + direction[1];

            if (newR < 0 || newR >= gRow || newC < 0 || newC >= gCol || gWallpaper[newR][newC] != '#')
                continue;

            dfs(newR, newC);
        }
    }
}