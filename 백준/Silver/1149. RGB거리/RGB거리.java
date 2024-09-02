import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j, n = sc.nextInt(); 
		int d[][] = new int[n+1][3];
        int a[][] = new int[n+1][3];
		for(i=1;i<=n;i++)
            for(j=0;j<3;j++)
                a[i][j] = sc.nextInt();
		d[0][0] = d[0][1] = d[0][2] = a[0][0] = a[0][1] = a[0][2] = 0;
		for(i=1;i<=n;i++){
			d[i][0] = Min(d[i-1][1], d[i-1][2]) + a[i][0];
			d[i][1] = Min(d[i-1][0], d[i-1][2]) + a[i][1];
			d[i][2] = Min(d[i-1][0], d[i-1][1]) + a[i][2];
		}
		System.out.println(Min(Min(d[n][0], d[n][1]), d[n][2]));
		sc.close();
	}
	public static int Min(int a, int b){ return a < b ? a : b; }
 }