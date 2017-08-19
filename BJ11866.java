import java.util.ArrayList;
import java.util.Scanner;

public class BJ11866 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		solve(n,m);
	}

	static void solve(int n, int m) {
		ArrayList<Integer> input = new ArrayList<>();
		int[] output = new int[n];
		int currentIdx = -1 ;
		int outputIdx = 0;
		for(int i = 0 ; i < n ; i ++) {
			input.add(i+1);
		}
		while(input.size() > 0) {
			for(int i = 0 ; i < m ; i++) {
				currentIdx++;
				if(currentIdx >= input.size()) {
					currentIdx = 0;
				}
				
				if(i==m-1) {

//						System.out.println("currnetIdx = "+ currentIdx);
						output[outputIdx++] = input.get(currentIdx);
						input.remove(currentIdx);
//						System.out.println(input.size());
						currentIdx--;
					
				
				}
			}
		}

		StringBuilder str = new StringBuilder("<");
		for(int i = 0 ; i < output.length; i ++) {
			if(i < output.length-1) 
			{
				str.append(output[i]+", ");
			}
			else {
				str.append(output[i]+">");	
			}
		}
		System.out.println(str.toString());


	}
}
