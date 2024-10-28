#include <stdio.h>
bool Is_leap(int Y) {
	if ((Y % 4 == 0 && Y % 100 != 0) || Y % 400 == 0) return true;
	return false;
}
void D_Day(int y1, int y2, int m1, int m2, int d1, int d2) {
	int month[13] = { 0, 31,28,31,30,31,30,31,31,30,31,30,31 };
	int day = 0;

	for (int y = y1 + 1; y < y2; y++) {
		day += 365;
		if (Is_leap(y)) day++;
	}

	if (y1 != y2) {
		for (int m = m1 + 1; m <= 12; m++) {
			day += month[m];
			if (m == 2 && Is_leap(y1)) day += 1;
		}
		for (int m = 1; m < m2; m++) {
			day += month[m];
			if (m == 2 && Is_leap(y2)) day += 1;
		}
		day += (month[m1] - d1);
		if (m1 == 2 && Is_leap(y1)) day += 1;
		day += d2;
	}
	else {
		if (m1 != m2) {
			for (int m = m1 + 1; m < m2; m++) {
				day += month[m];
				if (m == 2 && Is_leap(y1)) day += 1;
			}
			day += (month[m1] - d1);
			if (m1 == 2 && Is_leap(y1)) day += 1;
			day += d2;
		}
		else day += (d2 - d1);
	}
	printf("D-%d", day);
}
int main() {
	int y1, y2, m1, m2, d1, d2;
	scanf("%d %d %d", &y1, &m1, &d1);
	scanf("%d %d %d", &y2, &m2, &d2);

	if (y2 - y1 > 1000) printf("gg");
	else if (y2 - y1 == 1000) {
		if (m2 >= m1 && d2 >= d1) printf("gg");
		else D_Day(y1, y2, m1, m2, d1, d2);
	}
	else D_Day(y1, y2, m1, m2, d1, d2);
	return 0;
}
