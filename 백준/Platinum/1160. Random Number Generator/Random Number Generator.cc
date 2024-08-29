#include <stdio.h>

typedef struct {
	long long array[2][2];
} Matrix;

long long multiply_modular (long long x, long long y, long long M); // x * y mod M

Matrix matrix_multiply_modular_2by2 (Matrix A, Matrix B, long long M); // AB mod M

int main() {
	long long m, a, c, X0, n, g;
	scanf("%lld %lld %lld %lld %lld %lld", &m, &a, &c, &X0, &n, &g);
	
	X0 %= m;
	a %= m;
	c %= m;
	
	Matrix U, V, W;
	U.array[0][0] = X0, U.array[0][1] = 1, U.array[1][0] = 0, U.array[1][1] = 0;
	V.array[0][0] = a, V.array[0][1] = 0, V.array[1][0] = c, V.array[1][1] = 1;
	W.array[0][0] = 1, W.array[0][1] = 0, W.array[1][0] = 0, W.array[1][1] = 1;
	
	while (n > 0) { // W = V^n
		if (n & 1) {
			W = matrix_multiply_modular_2by2 (W, V, m);
		}
		V = matrix_multiply_modular_2by2 (V, V, m);
		n >>= 1;
	}
	U = matrix_multiply_modular_2by2 (U, W, m); // U * W = U * (V^n)
	
	printf("%lld", U.array[0][0] % g);
	
	return 0;
}

long long multiply_modular (long long x, long long y, long long M) {
	x %= M;
	y %= M;
	long long temp = x;
	long long result = 0;
	while (y > 0) {
		if (y & 1) {
			result = (result + temp) % M;
		}
		temp = (2 * temp) % M;
		y >>= 1;
	}
	return result;
}

Matrix matrix_multiply_modular_2by2 (Matrix A, Matrix B, long long M) {
	Matrix result;
	int i, j, k;
	for (i = 0; i <= 1; i++) {
		for (j = 0; j <= 1; j++) {
			result.array[i][j] = 0;
			for (k = 0; k <= 1; k++) {
				long long temp = multiply_modular(A.array[i][k], B.array[k][j], M);
				result.array[i][j] = (result.array[i][j] + temp) % M;
			}
		}
	}
	return result;
}