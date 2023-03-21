import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] edges;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            edges = new ArrayList[N + 1];
            visited = new boolean[N + 1];
            for (int i = 0; i <= N; i++) {
                edges[i] = new ArrayList();
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                edges[s].add(e);
                edges[e].add(s);
            }
            for (int i = 0; i <= N; i++) {
                Collections.sort(edges[i]);
            }

            DFS(V);
            Arrays.fill(visited, false);
            System.out.println();
            BFS(V);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void DFS(int V) {
        if (!visited[V]) {
            visited[V] = true;
            System.out.print(V + " ");
            for (int i = 0; i < edges[V].size(); i++) {
                DFS(edges[V].get(i));
            }
        }
    }

    public static void BFS(int V) {
        if(!visited[V]){
            visited[V] = true;
            System.out.print(V + " ");
            for(int i = 0; i < edges[V].size(); i++){
                queue.offer(edges[V].get(i));
            }
            while(!queue.isEmpty()){
                BFS(queue.poll());
            }
        }
    }
}
