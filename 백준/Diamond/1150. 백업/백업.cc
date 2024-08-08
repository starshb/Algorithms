#include <cstdio>
#include <vector>
#include <queue>
typedef struct data {
    int val, left, right;
    bool operator <(data &b)const {
        return val < b.val;
    }
}data;
struct comp {
    bool operator()(data a, data b) {
        return a.val > b.val;
    }
};
 
int main() {
    std::priority_queue<data, std::vector<data>, comp> pty_queue;
    int n, k, res = 0, p;
    data point[100001];
    scanf("%d%d%d", &n, &k, &p);
    for (int i = 1, tmp; i < n; i++) {
        scanf("%d", &tmp);
        point[i].val = tmp - p;
        point[i].left = i - 1;
        point[i].right = i + 1;
 
        pty_queue.push(data{ point[i].val , i, i + 1 });
        p = tmp;
    }
    point[n] = { 0, n - 1, n + 1 };
 
    for (int i = 0; i < k;) {
        data t = pty_queue.top();
        pty_queue.pop();
        int cl = t.left, cr = t.right;
        if (cl >= 1 && cr <= n && cr == point[cl].right && cl == point[cr].left) {
            res += t.val;
            if (++i >= k) break;
            int nl = point[cl].left, nr = point[cr].right;
            t.left = nl; t.right = nr;
            point[nl].val = point[nl].val + point[cr].val - t.val;
            t.val = point[nl].val;
            pty_queue.push(t);
            point[nl].right = nr;
            point[nr].left = nl;
 
        }
    }
    printf("%d", res);
    return 0;
}
 

