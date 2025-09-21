import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	private static class Node{
		int dest; // 목적지
		int weight;
		
		public Node(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
	}
	private static final int INF = Integer.MAX_VALUE;
	private static int V;
	private static ArrayList<Node>[] adjList;
	private static int[] dist;
	private static boolean[] visited;
	
	public static void main(String[] args)throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[V +1];
		for(int i = 0; i<=V; i++) {
			adjList[i] = new ArrayList<>();
		}
		visited = new boolean[V+1];
		
		int start = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[u].add(new Node(v,w));
		}
		
	
		go(start);
		for(int i = 1; i <= V; i++) { // V까지 순회
		    if(dist[i] == INF) {
		        System.out.println("INF");
		    } else {
		        System.out.println(dist[i]);
		    }
		}
		
	}
	
	private static void go(int start) {
		
		dist = new int[V+1];
		Arrays.fill(dist, INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.weight-o2.weight);
		
		dist[start] = 0;
		pq.offer(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			int currentDestination = current.dest;
			int currentWeight = current.weight;
			
			if(dist[currentDestination] < currentWeight) {
				continue;
			}
			
			for(Node next : adjList[currentDestination]) {
				int nextDestination = next.dest;
				int nextWeight = next.weight;
				
				if(dist[nextDestination] > currentWeight + nextWeight) {
					dist[nextDestination] = currentWeight + nextWeight;
					pq.offer(new Node(nextDestination, dist[nextDestination]));
				}
			}
		
		}
	}
}