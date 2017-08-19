import java.util.Arrays;
import java.util.Scanner;

public class BJ2579 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int input[] = new int[n+1];
		for(int i  = 1 ; i <n+1 ; i ++ ) {
			input[i] = sc.nextInt();
		}
		int res = 0 ;
		int select[] = new int[n+1];

		select[1] = input[1];
		select[2] = input[1]+input[2];

		for(int i = 3 ; i <= n ; i++) {

			if(i>=4) {
				select[i] = Math.max(input[i]+input[i-1]+select[i-3], input[i]+select[i-2]);
			}
			else {
				select[i] = Math.max(input[i]+input[i-1]+input[i-3],  input[i]+input[i-2]);
			}
		}

//		System.out.println(Arrays.toString(select));
				System.out.println(select[n]);

	}


}
