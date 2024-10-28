#include <iostream>
#include <string>
#include <cmath>
#include <set>
#include <map>
#include <stack>
#include <queue>
#include <vector>
#include <algorithm>
#include <climits>
#define FASTIO cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 1000001
#define LL long long
#define INF 1e9

using namespace std;
int N, M;
int Tree_Height, Tree_Size;
vector<int> SegTree;
int MAP[MAX];

void Input() {
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		cin >> MAP[i];
	}
}

int Make_SegTree(int Node, int Start, int End) {
	if (Start == End) {
		return SegTree[Node] = MAP[Start];
	}
	int MID = (Start + End) / 2;
	return SegTree[Node] = max(Make_SegTree(Node * 2, Start, MID), Make_SegTree(Node * 2 + 1, MID + 1, End));
}

int Find_Max_Value(int Node, int Start, int End, int Left, int Right) {
	if ((Left > End) || (Start > Right)) {
		return -1;
	}
	if ((Left <= Start) && (End <= Right)) {
		return SegTree[Node];
	}
	int MID = (Start + End) / 2;
	return max(Find_Max_Value(Node * 2, Start, MID, Left, Right), Find_Max_Value(Node * 2 + 1, MID + 1, End, Left, Right));
}

void Settings() {
	Tree_Height = (int)ceil(log2(N));
	Tree_Size = (1 << (Tree_Height + 1));
	SegTree.resize(Tree_Size);
	Make_SegTree(1, 0, N - 1);
}

void Find_Answer() {
	for (int i = M - 1; i <= (N - M); i++) {
		cout << Find_Max_Value(1, 0, N - 1, i - (M - 1), i + (M - 1)) << " ";
	}
	cout << "\n";
}

int main() {
	FASTIO
	Input();
	Settings();
	Find_Answer();

	return 0;
}