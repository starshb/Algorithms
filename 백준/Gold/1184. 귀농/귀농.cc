#include <iostream>
#include <algorithm>
#include <vector>
#include <map>
using namespace std;

int n;
int board[51][51];
int psum[51][51];
int result = 0;

map<int, int>::iterator it;

int main()
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	cin >> n;

	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			int input;
			cin >> input;

			board[i][j] = input;
		}
	}

	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			psum[i][j] = psum[i][j - 1] + psum[i - 1][j] - psum[i - 1][j - 1] + board[i][j];
		}
	}

	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			//map에 (합, 합이 나온 개수)저장
			map<int, int> right_down;
			map<int, int> left_up;
			map<int, int> left_down;
			map<int, int> right_up;

			pair<int, int> point = make_pair(i, j);

			int this_sum;

			//point를 기준으로 왼쪽위, 오른쪽아래 면적의 경우
			for (int a = point.first; a >= 1; a--)
			{
				for (int b = point.second; b >= 1; b--)
				{
					this_sum = psum[point.first][point.second] - psum[point.first][b - 1] - psum[a - 1][point.second] + psum[a - 1][b - 1];

					if (left_up.count(this_sum) == 0)
						left_up.insert(make_pair(this_sum, 1));
					else
						left_up[this_sum]++;
				}
			}
			for (int a = point.first + 1; a <= n; a++)
			{
				for (int b = point.second + 1; b <= n; b++)
				{
					this_sum = psum[a][b] - psum[a][point.second + 1 - 1] - psum[point.first + 1 - 1][b] + psum[point.first + 1 - 1][point.second + 1 - 1];

					if (right_down.count(this_sum) == 0)
						right_down.insert(make_pair(this_sum, 1));
					else
						right_down[this_sum]++;
				}
			}

			//point를 기준으로 오른쪽위, 왼쪽아래 면적의 경우
			for (int a = point.first; a >= 1; a--)
			{
				for (int b = point.second; b <= n; b++)
				{
					this_sum = psum[point.first][b] - psum[point.first][point.second - 1] - psum[a - 1][b] + psum[a - 1][point.second - 1];

					if (right_up.count(this_sum) == 0)
						right_up.insert(make_pair(this_sum, 1));
					else
						right_up[this_sum]++;
				}
			}
			for (int a = point.first + 1; a <= n; a++)
			{
				for (int b = point.second - 1; b >= 1; b--)
				{
					this_sum = psum[a][point.second - 1] - psum[a][b - 1] - psum[point.first + 1 - 1][point.second - 1] + psum[point.first + 1 - 1][b - 1];

					if (left_down.count(this_sum) == 0)
						left_down.insert(make_pair(this_sum, 1));
					else
						left_down[this_sum]++;
				}
			}

			//point를 기준으로 왼쪽위, 오른쪽아래 경우에서 같은 면적인 경우의수 확인
			for (it = left_up.begin(); it != left_up.end(); it++)
			{
				if (right_down.count((*it).first) != 0)
					result += ((*it).second * right_down[(*it).first]);
			}

			//point를 기준으로 오른쪽위, 왼쪽아래 면적의 경우에서 같은 면적인 경우의수 확인
			for (it = right_up.begin(); it != right_up.end(); it++)
			{
				if (left_down.count((*it).first) != 0)
					result += ((*it).second * left_down[(*it).first]);
			}


		}
	}

	cout << result;

	return 0;
}