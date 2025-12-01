import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<N; i++){

            String line = br.readLine();

            char[] arr = line.toCharArray();
            int idx = 0;
            for(int j = 1; j<arr.length;j++){

                if(arr[j]== ' '){
                    for(int k = j-1; k>=idx;k--){
                        sb.append(arr[k]);
                    }
                    sb.append(arr[j]);
                    idx = j+1;
                }
            }

            for(int j = arr.length-1; j>=idx;j--){
                sb.append(arr[j]);
            }

            sb.append('\n');
        }
        System.out.println(sb);
    }
}