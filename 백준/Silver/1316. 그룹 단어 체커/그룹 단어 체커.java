import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i = 0; i<N; i++){
            String line = br.readLine();

            //line에 대해서 판별.
            //그룹단어면 ans++
            if(group(line)){
                ans++;
            }
        }
        System.out.println(ans);
    }
    private static boolean group(String line){
        if(line.length()==1) return true;

        int[] arr = new int[26];
        boolean isGroup = true;

        char first = line.charAt(0);
        int firstIdx = first - 'a';

        arr[firstIdx]++;

        for(int i = 1; i<line.length(); i++){
            char c = line.charAt(i);
            int cIdx = c-'a';
            if(arr[cIdx] != 0){
                char prev = line.charAt(i-1);
                if(c!=prev){
                    isGroup = false;
                    break;
                }else{
                    //이전 문자랑 같다. 연속된다.
                    arr[cIdx]++;
                }
            }else{
                //새로운 문자다.
                arr[cIdx]++;
            }
        }

        return isGroup;
    }
}