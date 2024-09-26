#include <cstdio>
int main(void){
	int N, R1, C1, R2, C2,i1,j1;
	scanf("%d %d %d %d %d",&N,&R1,&C1,&R2,&C2);
	for(int i=R1; i<=R2; i++){
		for(int j=C1; j<=C2; j++){
			i1 = i % (2*N-1);
			j1 = j % (2*N-1);
			if(i1>N-1)
				i1 = 2*N - 2 - i1;
			if(j1>N-1)
				j1 = 2*N - 2 - j1;
			if(i1+j1<N-1)
				printf(".");
			else
				printf("%c",97+(2*N-2-(i1+j1))%26);
		}
		printf("\n");
	}
}