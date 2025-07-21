import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        int lastCameraPosition = Integer.MIN_VALUE;
        
        for(int []r : routes){
            int entry = r[0];
            int exit = r[1];
            
            if(entry > lastCameraPosition){
                answer++;
                lastCameraPosition = exit;
            }
        }
        return answer;
    }
}