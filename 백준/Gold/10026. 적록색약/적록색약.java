import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static char [][]arr;
	private static char[][] arr2;
	private static int cnt,cnt2;
	private static boolean[][] visited;
	private static int[]dx = {-1,1,0,0};
	private static int[]dy = {0,0,-1,1};
	
	
	public static void main(String[] args)throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		arr2 = new char[N][N];
		
		for(int i = 0; i< N ; i++) {
			String line = br.readLine();
			for(int j =0; j<N;j++) {
				arr[i][j] = line.charAt(j);
				if(line.charAt(j) == 'G') {
					arr2[i][j] = 'R';
				}else {
					arr2[i][j] = line.charAt(j);
				}
				
			}
		}
		
		visited = new boolean[N][N];
		
		for(int i =0; i<N;i++) {
			for(int j = 0; j<N;j++) {
				if(visited[i][j]) continue;
				visited[i][j] = true;
				dfs(arr,i,j);
				cnt++;
				visited[i][j] = false;
			}
		}
		
		visited = new boolean[N][N];
		for(int i =0; i<N;i++) {
			for(int j = 0; j<N;j++) {
				if(visited[i][j]) continue;
				visited[i][j] =true;
				dfs(arr2,i,j);
				cnt2++;
				
			}
		}
	
		
		System.out.println(cnt + " " + cnt2);
		
	}
	
	private static void dfs(char[][]arr,int x, int y) {
			
		char color = arr[x][y];
		
		for(int i =0; i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N)continue;
			
			if(visited[nx][ny]) continue;
			if(arr[nx][ny] != color)continue;
			visited[nx][ny] = true;
			dfs(arr,nx,ny);
		}
			
	}
	
}