import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        dfs(0);
    }

    public static void dfs(int cnt){
        if(cnt == N){
            System.out.println(Arrays.toString(arr).replace("[","").replace("]","").replace(",",""));
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i-1]){
                visited[i-1] = true;
                arr[cnt] = i;
                dfs(cnt+1);
                visited[i-1] = false;
            }
        }

    }
}
