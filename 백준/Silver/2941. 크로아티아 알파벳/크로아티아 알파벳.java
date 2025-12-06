import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        // 순서 중요: dz= 이 z= 보다 먼저 와야 함
        String[] cro = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String c : cro) {
            line = line.replace(c, "*");
        }

        System.out.println(line.length());
    }
}