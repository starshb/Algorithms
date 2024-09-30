#include "stdio.h"
#include "string.h"

// 문자열에 있는 'L' ,'O', 'V' ,'E' 개수 카운트
void countLoveCharacter(char name[], int love[4]) {
    for (int i = 0; name[i] != 0; i++) {
        if (name[i] == 'L') {
            love[0]++;
            continue;
        }
        if (name[i] == 'O') {
            love[1]++;
            continue;
        }
        if (name[i] == 'V') {
            love[2]++;
            continue;
        }
        if (name[i] == 'E') {
            love[3]++;
            continue;
        }
    }
}

int main(void) {
    char name[21], team[21], answer[21];
    int n;
    int love[4] = {0}; // 연두 이름에 있는 'L','O','V' ,'E' 개수
    scanf("%s", name);
    scanf("%d", &n);
    countLoveCharacter(name, love); // 'L','O','V','E' 카운트 세기
    int max = -1;
    while (n--) {
        scanf("%s", team);
        int love2[4] = {0}; // 팀 이름에 있는 'L','O','V' ,'E' 개수
        countLoveCharacter(team, love2); // 'L','O','V','E' 카운트 세기
        love2[0] += love[0];  // 연두와 팀이름에 있는 'L'의 총 개수 
        love2[1] += love[1];  // 연두와 팀이름에 있는 'O'의 총 개수 
        love2[2] += love[2];  // 연두와 팀이름에 있는 'V'의 총 개수 
        love2[3] += love[3];  // 연두와 팀이름에 있는 'E'의 총 개수 
        int percentage = 1; // 이환이가 만든 공식
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                percentage *= (love2[i] + love2[j]);
            }
        }
        percentage %= 100;
        if (percentage > max) { // 확률이 제일 높으면 max 값 갱신
            max = percentage;
            strcpy(answer, team); // answer에 해당 팀 이름 저장
        } else if (percentage == max) { // 확률 값이 같으면 사전 순으로 비교
            if (strcmp(answer, team) > 0) {
                strcpy(answer, team); // 사전 순으로 앞에 오는 팀이름 저장
            }
        }
    }
    printf("%s", answer);
}

