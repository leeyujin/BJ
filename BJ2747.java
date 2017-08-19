import java.util.Scanner;

public class BJ2747 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] k = new int[n+1];
		k[0]= 0;
		k[1] = 1;
		k[2] = 1;
		
		for(int i = 3; i <= n ; i++) {
		fibo(k,i);
		}
		System.out.println(k[n]);
	}


	static void fibo(int[] k, int i ) {
		k[i] = k [i-1] + k[i-2];
		
	}

}
