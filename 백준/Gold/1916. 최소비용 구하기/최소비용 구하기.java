
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static class Node{
        int to,weight;
        public Node(int to, int weight){

            this.to = to;
            this.weight = weight;
        }
    }
    private static int N, M;
    private static ArrayList<Node> [] adjList;
    private static int[]dist;


    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        dist = new int[N+1];
        for(int i = 1; i<=N;i++){
            adjList[i] = new ArrayList<>();
        }
        Arrays.fill(dist,Integer.MAX_VALUE);


        for(int i = 0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[from].add(new Node(to,weight));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());



        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        dist[start] = 0;
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            if(dist[curr.to] < curr.weight){
                continue;
            }
            for(Node next : adjList[curr.to]){
                if(dist[next.to] > next.weight + dist[curr.to]){
                    dist[next.to] = dist[curr.to] + next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }

        System.out.println(dist[end]);

    }



}
