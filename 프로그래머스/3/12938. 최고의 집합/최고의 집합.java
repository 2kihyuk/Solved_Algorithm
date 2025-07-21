class Solution {
    public int[] solution(int n, int s) {
        int[] answer;
        
        if(n > s){
            return new int[]{-1};
        }
        
        int value = s/n;
        int reminder = s%n;
        
        answer = new int[n];
        for(int i =0; i<n; i++){
            answer[i] = value;
        }
        
        for(int i =0; i<reminder;i++){
            answer[n-i-1]++;
        }
        
        return answer;
    }
    
}