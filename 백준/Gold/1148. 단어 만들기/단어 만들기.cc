# include <iostream>
# include <vector>
# include <string>
# include <algorithm>
using namespace std;

// 단어 개수를 저장해놓으면 개수가 맞는지 + 가운데 글자가 있는지만 

char gameboard[9];

int main() {
	int wordcnt = 0;
	int** arr = new int* [200001];
	for (int i = 0; i < 200001; i++) {
		arr[i] = new int[26];
	}
	for (int i = 0; i < 200001; i++) {
		for (int j = 0; j < 26; j++) {
			arr[i][j] = 0;
		}
	}
	int** board = new int* [200001];
	for (int i = 0; i < 200001; i++) {
		board[i] = new int[26];
	}
	for (int i = 0; i < 200001; i++) {
		for (int j = 0; j < 26; j++) {
			board[i][j] = 0;
		}
	}
	string temp;
	while (temp != "-") {
		cin >> temp;
		if (temp != "-") {
			for (int j = 0; j < temp.length(); j++) {
				arr[wordcnt][temp[j] - 65] += 1; // 단어개수를 더해준다
			}
			wordcnt += 1;
		}
	};
	int cnt = 0;
	int cancnt = 0;
	int maxi = 0;
	int mini = 10;
	while (temp != "#") {
		cin >> temp;
		if (temp != "#") {
			for (int j = 0; j < 9; j++) {
				board[cnt][temp[j] - 65] += 1; // 단어개수를 더해준다
				gameboard[j] = temp[j];
			}

			// 글자에대해서
			int score[9] = { 0 };
			for (int k = 0; k < 9; k++) {
				// 몇가지 단어나 성공이 가능할지
				cancnt = 0;	
				for (int word = 0; word < wordcnt; word++) {
					int plag = 0;
					for (int q = 0; q < 26; q++) {
						if (board[cnt][q] < arr[word][q]) {
							plag = 1;
							break;
						}
					}
					if (plag == 0) {
						if (arr[word][gameboard[k] - 65] != 0) {
							cancnt += 1;
						}
					}
				}
				score[k] = cancnt;
			}
			int max = 0;
			int min = 500000;
			for (int x = 0; x <9; x++) {
				if (score[x] > max) {
					max = score[x];
				}
				if (score[x] < min) {
					min = score[x];
				}
			}
			vector<char>v_mini;
			vector<char>v_maxi;
			int min_count = 0;
			int max_count = 0;
			for (int v = 0; v < 9; v++) {
				if (score[v] == min && find(v_mini.begin(),v_mini.end(),gameboard[v]) == v_mini.end()){
					v_mini.push_back(gameboard[v]);
					min_count += 1;
				}
			}
			for (int v = 0; v < 9; v++) {
				if (score[v] == max && find(v_maxi.begin(), v_maxi.end(), gameboard[v]) == v_maxi.end()) {
					v_maxi.push_back(gameboard[v]);
					max_count += 1;
				}
			}
			sort(v_mini.begin(), v_mini.end());
			sort(v_maxi.begin(), v_maxi.end());
			for (int a = 0; a < min_count; a++) {
				cout << v_mini[a];
			}
			cout <<  " " << min << " ";
			for (int a = 0; a < max_count; a++) {
				cout << v_maxi[a];
			}
			cout << " " << max << endl;

			cnt += 1;
		}
	}
	return 0;
}