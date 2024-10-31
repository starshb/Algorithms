#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main()
{
	int a, b, n;	
	int result;		//결과를 받을변수

	scanf("%d %d %d", &a, &b, &n);	//a,b,n 입력받기

	for (int i = 0; i < n; i++)		//n번째 자리수를 구하기 위해서 n번을 반복
	{
		a %= b;		//a와b를 나눴을때 나머지를 a에 저장
		a *= 10;	//a에 10을 곱함
		result = a / b;	//결과값
	}

	printf("%d", result);

	return 0;
}