import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private enum Direction {
        R(0, 1), L(0, -1), B(-1, 0), T(1, 0),
        RT(1, 1), LT(1, -1), RB(-1, 1), LB(-1, -1),
        ;

        private final int mvCol;
        private final int mvRow;

        Direction(int mvRow, int mvCol) {
            this.mvRow = mvRow;
            this.mvCol = mvCol;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] king = getInput(st.nextToken());//col,row
        int[] stone = getInput(st.nextToken());
        int[] tempKing, tempStone;
        int cmdCnt = Integer.parseInt(st.nextToken());

        while (cmdCnt-- > 0) {
            String cmd = br.readLine();
            tempKing = move(cmd, king);
            if (isOverRange(tempKing)) continue;//킹이 범위를 넘어감

            if (tempKing[0] == stone[0] && tempKing[1] == stone[1]) {//킹,돌 같이 있음
                tempStone = move(cmd, stone);
                if (isOverRange(tempStone)) continue;
                stone = tempStone;
            }

            king = tempKing;
        }

        sb.append(print(king)).append("\n");
        sb.append(print(stone)).append("\n");
        System.out.println(sb);
    }

    private static int[] getInput(String input) {
        return new int[]{input.charAt(0) - 'A', input.charAt(1) - '1'};
    }

    private static String print(int[] map) {
        return Character.toString(map[0] + 'A') + (map[1] + 1);
    }

    private static boolean isOverRange(int[] temp) {
        return temp[0] < 0 || temp[1] < 0 || 8 <= temp[0] || 8 <= temp[1];
    }

    private static int[] move(String cmd, int[] map) {//가로줄 , 세로줄
        Direction direction = Direction.valueOf(cmd);
        return new int[]{map[0] + direction.mvCol, map[1] + direction.mvRow};
    }
}
