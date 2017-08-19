import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BJ1149 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[][] input = new int[t+1][3];
		for(int j = 1 ; j <= t; j ++) {
			for(int k = 0 ; k < 3 ; k++) {
				input[j][k] = sc.nextInt();
			}
		}
		solve(input);
	}
	
	static void solve(int[][] input) {
		int[][] minVal = new int[input.length][3];
		

		
		for(int i = 1 ; i < input.length ; i ++) {
				minVal[i][0] = Math.min(minVal[i-1][1]+input[i][0], minVal[i-1][2]+input[i][0]);
				minVal[i][1] = Math.min(minVal[i-1][0]+input[i][1], minVal[i-1][2]+input[i][1]);
				minVal[i][2] = Math.min(minVal[i-1][0]+input[i][2], minVal[i-1][1]+input[i][2]);
		}
//		for(int i = 1 ; i < input.length ; i ++) {
//			for(int j = 0 ; j < 3 ; j ++) {
//				System.out.print(minVal[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
		System.out.println(Math.min(minVal[input.length-1][0], Math.min(minVal[input.length-1][1], minVal[input.length-1][2])));
	}
	
}
