import java.util.*;

class Solution {
    public static int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        Point border = new Point(m, n);
        Point start = new Point(startX, startY);

        for (int i = 0; i < balls.length; i++) {
            int[] ball = balls[i];

            List<Point> transBall = symmetricTransposition(border, start, new Point(ball[0], ball[1]));

            int minDistance = Integer.MAX_VALUE;
            for (Point point : transBall) {
                int dis = calculationDistance(start, point);

                minDistance = Math.min(minDistance, dis);
            }

            answer[i] = minDistance;
        }


        return answer;
    }

    private static List<Point> symmetricTransposition(Point bord, Point start, Point ball) {
        List<Point> syms = new ArrayList<>();

        // 4 개의 방향으로 대칭이동
        // 선 대칭일 때, 벽보다 공에 먼저 맞는 경우 제외
        if(!(start.x == ball.x && start.y > ball.y)) syms.add(new Point(ball.x, ball.y * -1));
        if(!(start.x == ball.x && start.y < ball.y)) syms.add(new Point(ball.x, bord.y + (bord.y- ball.y)));
        if(!(start.y == ball.y && start.x < ball.x)) syms.add(new Point(bord.x + (bord.x - ball.x), ball.y));
        if(!(start.y == ball.y && start.x > ball.x)) syms.add(new Point(ball.x * -1 , ball.y));

        return syms;
    }

    private static int calculationDistance(Point start, Point ball){
        int bigX = Math.max(start.x, ball.x);
        int smallX = Math.min(start.x, ball.x);
        int bigY = Math.max(start.y, ball.y);
        int smallY = Math.min(start.y, ball.y);

        return (int)Math.pow(bigX - smallX, 2) + (int)Math.pow(bigY - smallY, 2);
    }

    private static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}