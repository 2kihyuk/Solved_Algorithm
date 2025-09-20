import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	
	private static int N;
	private static int K;
	private static int count;
	private static int[] visited;
	public static void main(String[] args)throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		visited = new int[100001];
		if(N >= K) {
			System.out.println(N-K);
		}else {
			System.out.println(bfs());
		}
	
	}
	
	private static int bfs() {
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(N);
		visited[N] = 1;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			if(current == K) {
				return visited[current] - 1;
			}
			
			int next1= current + 1;
			int next2= current - 1;
			int next3 = current * 2;
			
			if(next1 < 100001 && visited[next1] == 0) {
				q.offer(next1);
				visited[next1] = visited[current] + 1;
			}
			if(next2 >= 0 && visited[next2] == 0) {
				q.offer(next2);
				visited[next2] = visited[current] + 1;
			}
			if(next3 < 100001 && visited[next3] == 0) {
				q.offer(next3);
				visited[next3] = visited[current] + 1;
			}
		}
		return -1;
	}
	
}