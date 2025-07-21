class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        boolean [][] visited = new boolean[n+1][m+1];
        
        for(int i=0; i<puddles.length;i++){
            visited[puddles[i][1]][puddles[i][0]] = true;
        }
        //물웅덩이 위치 는 true로 설정.

        int count[][] = new int[n+1][m+1];
        count[1][1] = 1;
        
        for(int i = 1; i<n+1;i++){
            
            for(int j =1 ; j<m+1;j++){
                if(visited[i][j]) continue;
                count[i][j] += count[i-1][j] + count[i][j-1];
                count[i][j]%=1000000007;
            }
        }
       
        return count[n][m];
    }
    
}