import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][]arr;
    private static boolean[][]visited;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        arr = new int[N][N];

        int maxHeight = 0;

        for(int i = 0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight,arr[i][j]);
            }
        }

        int answer = -1;

        for(int k = 0; k<=maxHeight;k++){
            visited = new boolean[N][N];
            int count = 0;
            for(int i = 0; i<N;i++){
                for(int j =0; j<N;j++){

                    if(arr[i][j] > k && !visited[i][j]){
                       dfs(i,j,k);
                       count++;
                    }
                }
            }
            answer = Math.max(answer,count);
        }


        System.out.println(answer);
    }
    private static void dfs(int x, int y, int limit){

        visited[x][y] = true;
        for(int i = 0; i<4; i++){
            int nextX = x+dx[i];
            int nextY = y+dy[i];
            if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;

            if(!visited[nextX][nextY] && arr[nextX][nextY] > limit){
                dfs(nextX,nextY,limit);
            }

        }

    }
}