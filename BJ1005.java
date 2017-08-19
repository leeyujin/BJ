import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public class BJ1005 {
	static int level = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for(int j = 0; j < t ; j++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] delay = new int[n+1];
			int[][] adj = new int[n+1][n+1];
			int[] indegree = new int[n+1];

			for(int i = 1; i < n+1 ; i++) {
				delay[i] = sc.nextInt();
			}

			for(int i = 0 ; i < k ; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				adj[from][to]=1;
				indegree[to]++;
			}
			int w = sc.nextInt();

			int[] res = topologicalSort(indegree,adj,delay);
			System.out.println(res[w]);

		}
	}

	static int[] topologicalSort(int[] indegree, int[][] adj, int[] delay) {

		Queue<Integer> list = new LinkedList<>();
		int[] result = new int[indegree.length];


		for(int i = 1 ; i < indegree.length ; i++) {

			if(indegree[i] == 0) { //진입간선이 0인 녀석
				list.add(i);
				result[i] = delay[i];
				break;
			}

		}

		while(list.size() !=0) {
			int i = list.poll();

			for(int j = 1 ; j < indegree.length; j++) {

				if(adj[i][j] == 1) {

					result[j] = Math.max(result[j], result[i]+delay[j]);

					indegree[j]--;
					if(indegree[j] == 0 ) {
						list.add(j);
					}
				}
			}

		}


		return result;
	}
}











