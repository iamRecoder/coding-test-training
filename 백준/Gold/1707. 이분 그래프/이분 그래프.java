import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] edges;
    static int[] check;
    static boolean[] visited;
    static boolean isEven;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for (int t = 0; t < K; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            edges = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            isEven = true;
            for (int j = 1; j <= V; j++) {
                edges[j] = new ArrayList<>();
            }
            // 에지 데이터 저장
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                edges[s].add(e);
                edges[e].add(s);
            }
            // 모든 노드에서 DFS 실행
            for(int i = 1; i <= V; i++){
                if(isEven) {
                    DFS(i);
                }else{
                    break;
                }
            }

            if(isEven){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }

    }

    private static void DFS(int start) {
        visited[start] = true;
        for(int end : edges[start]){    // start와 연결된 모든 노드를 탐색
            if(!visited[end]){
                check[end] = (check[start] + 1) % 2;
                DFS(end);
            }else if(check[start] == check[end]){
                    isEven = false;
            }
        }
    }
}
