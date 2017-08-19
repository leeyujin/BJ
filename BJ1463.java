import java.util.Arrays;
import java.util.Scanner;

public class BJ1463 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res[] = new int[n+1];
		res[1] = 0;
		if(n>=2) {
			res[2] = 1;
			if(n>=3) {
				res[3] = 1;
			}
		}
		for(int i = 4 ; i <= n ; i++) {
			res[i] = res[i-1]+1;
			if( (i%2 == 0 ) && res[i/2] < res[i-1])
				res[i] = res[i/2]+1;
			if( (i%3 == 0) && res[i/3] < res[i-1])
				res[i] = res[i/3]+1;


		}

		System.out.println(res[n]);


	}

}








