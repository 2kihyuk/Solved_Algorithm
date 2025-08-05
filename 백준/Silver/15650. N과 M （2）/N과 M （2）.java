import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] numbers;
    static StringBuilder sb;
    
    public static void main(String [] args){
        
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        numbers = new int[M];
        
        sb = new StringBuilder();
        
        combination(0,1);
        System.out.println(sb);
        
    }
    private static void combination(int cnt, int start){
        
        if(cnt == M){
            for(int i =0; i<M;i++){
                sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = start; i<=N;i++){
            numbers[cnt] = i;
            combination(cnt + 1, i + 1);
        }
    }
    
    
}