import java.util.Scanner;

public class Main {
	public static int GCD(int a, int b) {
		if(b == 0)	return a;
		return GCD(b, a%b);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		System.out.println(M - GCD(N, M));
		scan.close();
	}

}