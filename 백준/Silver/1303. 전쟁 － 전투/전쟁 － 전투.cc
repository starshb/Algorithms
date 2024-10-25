#include <stdio.h>
#include <stdbool.h>

int n, m, w, b;
char a[101][101];
bool check[100][100];
const int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};

int dfs(int x, int y, char c)
{
    int ret = 1;
    check[x][y] = true;
    for (int i = 0; i < 4; i++)
    {
        int nx = x + dx[i], ny = y + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m)
            continue;
        if (!check[nx][ny] && a[nx][ny] == c)
            ret += dfs(nx, ny, c);
    }
    return ret;
}

int main()
{
    scanf("%d %d", &m, &n); // m: 가로 , n : 세로
    for (int i = 0; i < n; i++)
        scanf("%s", a[i]);
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (!check[i][j])
            {
                int k = dfs(i, j, a[i][j]);
                if (a[i][j] == 'W')
                    w += k * k;
                else
                    b += k * k;
            }
        }
    }
    printf("%d %d\n", w, b);
    return 0;
}