#include <cstdio>

int tree[400005];

int init(int node, int s, int e) {
    if (s == e) return tree[node] = 1;
    int mid = (s + e) >> 1;
    return tree[node] = init(2 * node, s, mid) + init(2 * node + 1, mid + 1, e);
}

int query(int node, int s, int e, int k) {
    tree[node]--;
    if (s == e) return s;
    int mid = (s + e) >> 1;
    if (tree[2 * node] >= k) return query(2 * node, s, mid, k);
    else return query(2 * node + 1, mid + 1, e, k - tree[2 * node]);
}

int main() {
    int n, k; scanf("%d %d", &n, &k);
    init(1, 1, n);
    int x = k;
    printf("<");
    for (int i = 0; i < n - 1; i++) {
        printf("%d, ", query(1, 1, n, x));
        x += k - 1;
        if (x % tree[1] == 0) x = tree[1];
        else x %= tree[1]; 
    }
    printf("%d", query(1, 1, n, x));
    printf(">");
}