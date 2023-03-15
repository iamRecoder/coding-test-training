import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        adj = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) { // 인접 리스트 초기화
            adj[i] = new ArrayList<Integer>();
        }

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adj[s].add(e);
            adj[e].add(s);
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if(!visited[i]){
                cnt++;
                dfs(i);
            }
        }

        System.out.println(cnt);

    }

    static void dfs(int i) {
        if(visited[i]){
            return;
        }else{
            visited[i] = true;
            for(int j: adj[i]){
                if(visited[j] == false)
                    dfs(j);
            }
        }

    }
}
