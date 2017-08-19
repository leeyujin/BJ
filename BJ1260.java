import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BJ1260<T extends Comparable> {

	static void recDfs(Vertex<Integer> v, HashMap<Vertex<Integer>, TreeSet<Vertex<Integer>>> adjacent) {

		v.visited = true;
		System.out.print(v.toString());
		for(Vertex<Integer> w : adjacentTo(v,adjacent) ) {
			if(w.visited == false) {
				System.out.print(" ");
				recDfs(w, adjacent);
			}
		}
	}

	static void BFS(Queue<Vertex<Integer>> q, HashMap<Vertex<Integer>, TreeSet<Vertex<Integer>>> adjacent) {

		if(q.size() != 0) {
			Vertex<Integer> v = q.poll();
			v.visited = true;
			System.out.print (v.toString());
			for(Vertex<Integer> w : adjacentTo(v, adjacent)) {
				if(w.visited==false) {
					q.add(w);
					w.visited = true;
				}
			}
			if(q.size()!=0) {
			System.out.print(" ");
			BFS(q,adjacent);
			}

		}

	}

	static Iterable<Vertex<Integer>> adjacentTo(Vertex<Integer> v, HashMap<Vertex<Integer>, TreeSet<Vertex<Integer>>> adjacent){
		if(!adjacent.containsKey(v)) {
			return new TreeSet<>();
		}
		return adjacent.get(v);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt();

		HashMap<Integer, Vertex<Integer>> vertices = new HashMap<>();
		HashMap<Vertex<Integer>, TreeSet<Vertex<Integer>>> adjacent = new HashMap<>();

		for(int i = 1 ; i <= n ; i++) { //add Vertex
			vertices.put(i, new Vertex<Integer>(i));		
			adjacent.put(vertices.get(i), new TreeSet<>() );
		}
		for(int i = 0; i < m ; i ++) {
			int from = sc.nextInt();
			int to = sc.nextInt();

			Vertex<Integer> u = vertices.get(from);
			Vertex<Integer> v = vertices.get(to);
			adjacent.get(u).add(v);
			adjacent.get(v).add(u);
		}

//		Set<Vertex<Integer>> keySet = adjacent.keySet();
//		for(Vertex<Integer> k : keySet) {
////			System.out.println(k.toString());
//			for(Vertex<Integer> v : adjacent.get(k)) {
//				System.out.print("key "+k.toString()+"val" + v.toString()+" ");
//			}
//			System.out.println();
//		}
		StringBuilder sb = new StringBuilder();

		recDfs(vertices.get(s), adjacent);
		System.out.println();
		
		for(int i = 1; i <= n ; i++) {
			vertices.get(i).visited= false;
		}

		Queue<Vertex<Integer>> q = new LinkedList<>();
		q.add(vertices.get(s));
		BFS(q,adjacent);

	}

}

class Vertex<T extends Comparable> implements Comparable<Vertex<T>>{
	public Integer label;
	public boolean visited;

	public Vertex(Integer label) {
		this.label = label;
		visited = false;
	}

	@Override
	public int compareTo(Vertex<T> o) {
		// TODO Auto-generated method stub
		return label.compareTo(o.label);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return label.toString();
	}
}


