import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N; i++) {

            String line = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean impossible = false;

            for (char c : line.toCharArray()) {

                if (c == ')' && !stack.isEmpty()) {
                    stack.pop();
                } else if (c == ')' && stack.isEmpty()) {
                    impossible = true;
                } else {
                    stack.push(c);
                }

            }
            if(impossible){
                sb.append("NO");
            }else if(stack.isEmpty()){
                sb.append("YES");
            }else{
                sb.append("NO");
            }

            sb.append('\n');

        }
        System.out.println(sb);
    }
}