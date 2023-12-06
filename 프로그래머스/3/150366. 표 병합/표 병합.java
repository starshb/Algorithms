import java.util.*;

class Solution {
    public int[] parent = new int[2501];
    public String[] value = new String[2501];

    //UNION-FIND 알고리즘
    public int find(int a) {
        if (parent[a] == a)
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            parent[b] = a;
    }

    //좌표를 번호로 변환
    public int convertNum(int x, int y) {
        int result = 50 * (x - 1);
        return result + y;
    }

    public String[] solution(String[] commands) {
        //초기화
        for (int i = 1; i <= 2500; i++) {
            parent[i] = i;
            value[i] = "";
        }

        //명령어 실행
        List<String> result = new ArrayList<>();
        for (int ind = 0; ind < commands.length; ind++) {
            String line = commands[ind];
            StringTokenizer st = new StringTokenizer(line);
            String command = st.nextToken();

            if ("UPDATE".equals(command)) {
                //UPDATE value1 value2
                if (st.countTokens() == 2) {
                    String before = st.nextToken();
                    String after = st.nextToken();
                    for (int i = 1; i <= 2500; i++) {
                        if (before.equals(value[i]))
                            value[i] = after;
                    }
                }
                //UPDATE x y value
                else {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    String after = st.nextToken();
                    int num = convertNum(x, y);
                    value[find(num)] = after;
                }
            } else if ("MERGE".equals(command)) {
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                int n1 = convertNum(x1, y1);
                int n2 = convertNum(x2, y2);
                int root1 = find(n1);
                int root2 = find(n2);
                //0. 같은 그룹이면 무시
                if (root1 == root2) continue;
                //1. 값을 가진쪽으로 병합
                String rootString = value[root1].isBlank() ? value[root2] : value[root1];
                value[root1] = "";
                value[root2] = "";
                union(root1, root2);
                value[root1] = rootString;
            } else if ("UNMERGE".equals(command)) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int num = convertNum(x, y);
                int root = find(num);
                String rootString = value[root];
                value[root] = "";
                value[num] = rootString;
                List<Integer> deleteList = new ArrayList<>();
                for (int i = 1; i <= 2500; i++) {
                    if (find(i) == root)
                        deleteList.add(i);
                }
                for (Integer t : deleteList)
                    parent[t] = t;
            } else if ("PRINT".equals(command)) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int num = convertNum(x, y);
                int root = find(num);
                if (value[root].isBlank())
                    result.add("EMPTY");
                else
                    result.add(value[root]);
            }
        }
        return result.toArray(new String[0]);
    }

}