
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	private static int N;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i = 0; i<N;i++) {
			int card = Integer.parseInt(br.readLine());
			q.offer(card);
		}
		int ans = 0;
		while(!q.isEmpty()) {
			if(q.size()==1) break;
			
			int a = q.poll();
			int b = q.poll();
			ans+=(a+b);
			q.offer(a+b);
			
		}
		System.out.println(ans);
		
	}
}
