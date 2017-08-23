import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ2178 {

	static int[][] input;
	static int[] dx = { 1,-1,0,0 };
	static int[] dy = {0,0,1,-1};
	static int n , m;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		input = new int[n][m];

		for(int i = 0 ; i < n ; i++){

			String line = sc.next();

			for(int j = 0 ; j < m ; j ++){
				input[i][j] = Integer.parseInt(line.charAt(j)+""); 
			}

		}

		solve();

	}

	static void solve(){

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0,0));
		input[0][0]=2; //visit

		int count = 0;

		int mX,mY;

		while(!q.isEmpty()){

			count++;
			int size = q.size();

			for( int j = 0 ; j < size ; j ++){
				Node cN = q.poll();
				for(int i = 0; i < 4 ; i ++){
					mX = cN.x + dx[i];
					mY = cN.y + dy[i];
					if(mX >= 0 && mX < n && mY >= 0 && mY < m && input[mX][mY]==1){

						q.add(new Node(mX,mY));
						input[mX][mY] = 2; //visit
					}
					
					if(mX == n-1 && mY == m-1){
						System.out.println(count+1);
						return;
					}
					
				}
			}
		}

		System.out.println(count);


	}
}

//class Node{
//	int x;
//	int y;
//
//	public Node(int x, int y) {
//		// TODO Auto-generated constructor stub
//		this.x = x ;
//		this.y = y;
//	}
//}






