import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int M;
	private static ArrayList<Integer>[] adjList;
	private static boolean visited[];
	private static boolean isValid;
	private static int Tcnt = 0;
	
	public static void main(String[] args)throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N];
		visited = new boolean[N];
		
		for(int i =0; i<N;i++) {
			adjList[i]= new ArrayList<>();
		}
		
		for(int i =0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());	
			adjList[from].add(to);
			adjList[to].add(from);
		}
	
		for(int i =0; i<N;i++) {
			if(isValid) {
				break;
			}
			dfs(i,1);
		}
		
		
		System.out.println(isValid ? "1" : "0");
		
	}
	
	private static void dfs(int start, int cnt) {
		if(cnt == 5) {
			isValid = true;
			return;
		}
		
		visited[start] = true;
	
		for(int next : adjList[start]) {
			if(!visited[next]) {
				dfs(next, cnt + 1);
				if(isValid) {
				    return; // 5개 친구 관계를 찾았다면 즉시 종료
				}
			}
		}
		
		
		visited[start] = false;
	}
}