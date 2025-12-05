import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int multi = N / 4;

        for(int i = 0; i<multi; i++){
            sb.append("long").append(" ");
        }
        sb.append("int");

        System.out.println(sb);
    }
}