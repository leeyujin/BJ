import java.util.Scanner;

public class BJ11050 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println(binomialCoefiiecient(n, k));
	}
	
	static int binomialCoefiiecient(int n, int k ) {
		if( k < 0 || k > n)
			return 0;
		else {
			return factorial(n)/ (factorial(k)*factorial(n-k));
		}
	}
	
	static int factorial(int n) {
		if( n<=1) 
			return 1;
		else
			return  n * factorial(n-1);
	}
}
