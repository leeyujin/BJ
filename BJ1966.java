import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1966 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		ArrayList<Integer> input = new ArrayList<>();
		for(int i = 0 ; i < t ; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			for(int j = 0 ; j < n ; j++) {
				input.add(sc.nextInt());
			}
//			System.out.println("----");
//			for(int z : input) {
//				System.out.print(z + " ");
//			}
			solve(input,m);
			input.clear();
		}
	}
	static void solve(ArrayList<Integer> input, int m) {
		ArrayList<Integer> temp = new ArrayList<>();
		temp.addAll(input);
		int changeIdx = m;
		int count = 0;

		int max = Collections.max(input);
		int second = 0;

		while(temp.size() > 0) {
			int first = temp.get(0);
			if (first < max) {
				if(changeIdx >0 ) 
				{
					temp.remove(0);
					temp.add(first);
					changeIdx--;
				}else if (changeIdx == 0 ) {
					temp.remove(0);
					temp.add(first);
					changeIdx = temp.size()-1;
				}
			}else  //first == max
			{

				temp.remove(0);
				count++;
				if(changeIdx == 0) {
					System.out.println(count);
					return;
				}
				max = Collections.max(temp);
				changeIdx--;
			}

		}



	}

}
