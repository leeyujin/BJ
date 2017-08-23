import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BJ2667 {

	static int n;
	static int input[][];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static Queue<Node> q;
	static HashMap<Integer, Integer> map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n= sc.nextInt();

		input = new int[n][n];
		q = new LinkedList<>();

		for(int i = 0 ; i < n ; i ++){
			String str = sc.next();
			for(int j = 0 ; j < n ; j ++){
				input[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}

		solve();
		ArrayList<Integer> arr = new ArrayList<>();


		for(Integer key : map.keySet() ){
			arr.add(map.get(key));
		}


		Collections.sort(arr);

		System.out.println(map.size());
		for(int i : arr){
			System.out.println(i);
		}

//		for(Integer key : map.keySet() ){
//			System.out.println("key : "+ key + " value : " + map.get(key));
//		}

//		for(int i = 0 ; i < n ; i ++){
//			for(int j = 0 ; j < n ; j ++){
//				System.out.print(input[i][j]+" ");
//			}
//			System.out.println();
//		}
	}

	static void solve(){

		int bundle = 1;
		map = new HashMap<>();

		while(findOne() != -1){

			bundle++;

			while(!q.isEmpty()){

				Node cN = q.poll(); //currentNode
				int cX = cN.x; //currentX
				int cY = cN.y;
				input[cX][cY] = bundle;
				if(map.get(bundle)==null){
					map.put(bundle, 1);
				}

				for(int i = 0 ; i < 4; i ++){

					int mX = cX + dx[i]; //moveX
					int mY = cY + dy[i];
					
					if(mX >=0 && mX < n && mY >=0 && mY <n && input[mX][mY]==1){
						input[mX][mY] = bundle;
						q.add(new Node(mX,mY));
							map.put(bundle, map.get(bundle)+1);
					}
				}
			}
		}

	}

	static int findOne(){

		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n ; j++){
				if(input[i][j]==1){
					q.add(new Node(i,j));
					return 1;
				}
			}
		}


		return -1; // 끝까지 다  순회한경우 
	}




}

class Node{
	int x;
	int y ;
	public Node(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}


