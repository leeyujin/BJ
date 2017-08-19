import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class BJ9375 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0 ; i < t ; i ++) {
			HashMap<String,Integer> input = new HashMap<>();
			int n = sc.nextInt();
			for(int j = 0 ; j < n ; j++) {
				String name = sc.next();
				String type = sc.next();
				if(input.get(type) == null) 
				{
					input.put(type, 1);
				}else
				{
					input.put(type, input.get(type)+1);
				}
			
				
			}
			//System.out.println(input.size());
			solve(input);
			
		}
	}
	
	static void solve(HashMap<String,Integer> input) {
		int[] type = new int[input.size()];
		Set<String> keySet = input.keySet();
		String[] typeKey = keySet.toArray(new String[0]);
		
		if(typeKey.length == 1) 
		{
			System.out.println(input.get(typeKey[0]));
			return;
		}else
		{
			int res = 0 ; 
			int temp = 1;
			for(int j = 0 ; j < typeKey.length ; j++) {
				res += input.get(typeKey[j]);
				temp *= input.get(typeKey[j]);
			}
			System.out.println(res + temp);
			return;
		}
	}

}
