import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BJ1932 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] input = new int[n+1][n+1];
		for(int i = 1 ; i < n+1 ; i ++) {
			for(int j = 1 ; j <= i ; j++){
				input[i][j] = sc.nextInt();
			}
		}
		
		int[][] maxValue = new int[n+1][n+1];
		
		for(int i = 1 ; i <n+1 ; i++) {
			maxValue[n][i] = input[n][i];
		}
		
		for(int i = n ; i > 1 ; i--) {
			for(int j = 1 ; j < i ; j++) {
				maxValue[i-1][j] = Math.max(maxValue[i][j]+ input[i-1][j], 
						maxValue[i][j+1]+input[i-1][j]);
//				System.out.print(maxValue[i-1][j]+" ");
			}
			
//			System.out.println();
		}
		
		
		System.out.println(maxValue[1][1]);
	}

}
