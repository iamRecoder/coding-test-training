import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] arr;
    static int result = 0, N, S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        visited = new boolean[N];
        dfs(0, 0, 0);

        System.out.println(result);
    }

    public static void dfs(int cnt, int sum, int start){
       
        if(sum == S && cnt > 0){
            result++;
        }

        for(int i = start; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(cnt + 1, sum + arr[i], i + 1);
                visited[i] = false;
            }
        }
    }
}
