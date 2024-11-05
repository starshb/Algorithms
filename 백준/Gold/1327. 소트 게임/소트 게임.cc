#include <algorithm>
#include <iostream>
#include <string>
#include <queue>
#include <unordered_map>

using namespace std;
int K, N;

int bfs(string str)
{
    queue<pair<string, int>> que;
    que.push({str, 0});
    unordered_map<string, bool> visited;
    string target = str;
    sort(target.begin(), target.end());

    while (!que.empty())
    {
        string curent = que.front().first;
        int cnt = que.front().second;
        que.pop();

        if (curent == target)
        {
            return cnt;
        }
        if (!visited.count(curent))
        {
            visited[curent] = true;
            for (int j = 0; j <= N - K; j++)
            {
                string temp = curent.substr(j, K);
                reverse(temp.begin(), temp.end());
                que.push({curent.substr(0, j) + temp + curent.substr(j + K, curent.size()), cnt + 1});
            }
        }
    }
    return -1;
}

int main()
{
    cin >> N >> K;

    cin.ignore();
    string str;
    getline(cin, str);

    while (str.find(' ') != str.npos)
    {
        str.erase(str.find(' '), 1);
    }
    cout << bfs(str);
}