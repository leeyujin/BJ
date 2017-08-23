import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BJ2606 {

	static int input[][];
	static int n;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int edge = sc.nextInt();
		
		input = new int[n+1][n+1];
		
		for(int i = 0 ; i < edge ; i ++){
			int to = sc.nextInt();
			int from = sc.nextInt();
			
			input[to][from]=1;
			input[from][to]=1; //양방향
		}
		
		bfs();
		
	}
	
	static void bfs(){
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		
		Set<Integer> set = new HashSet<>();
		
		while(!q.isEmpty()){
			
			int x = q.poll();
			
			for(int i = 1 ; i <= n ; i++ ){
				if(input[x][i] ==1 ){
					input[x][i]=0;
					input[i][x]=0;
					q.add(i);
					set.add(i);
				}
			}
			
		}
		System.out.println(set.size());
		
		
		
		
	}

}

//class NodeI{
//	
//	int x ;
//	int y ;
//	
//	public NodeI(int x, int y) {
//		// TODO Auto-generated constructor stub
//		this.x = x;
//		this.y = y;
//	}
//	
//	
//}





