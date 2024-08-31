#include <stdio.h>
#define LL long long
const int MAX_N = 30 + 2;

char prior[6][3];
LL C[MAX_N][3];
int D[MAX_N][3];
int n;

int main() 
{
    // freopen("input.txt", "r", stdin);    
    scanf("%d", &n);
    
    C[0][0] = C[0][1] = C[0][2] = 0;
    for (int i = 0; i < 6; i++) {
        scanf("%s", &prior[i]);
        prior[i][0] -= 'A';
        prior[i][1] -= 'A';
        if (C[0][prior[i][0]] == 0) {
            D[0][prior[i][0]] = prior[i][1];
            C[0][prior[i][0]] = 1;
        }
    }

    for (int i = 1; i < n; i++) {
        for (int k = 0; k < 3; k++) {
            int tempDst = D[i - 1][k];
            int recDst = D[i - 1][tempDst];
            int nDst = 3 - k - tempDst;

            if (recDst == nDst) {
                C[i][k] = C[i - 1][k] + 1 + C[i - 1][tempDst];
                D[i][k] = nDst;
            }
            else {
                nDst = 3 - nDst - recDst;
                C[i][k] = 2 * C[i - 1][k] + 2 + C[i - 1][tempDst];
                D[i][k] = nDst;
            }
        }
    }

    printf("%lld\n", C[n - 1][0]);
}