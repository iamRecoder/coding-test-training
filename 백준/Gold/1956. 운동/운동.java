import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int sum = 0;
    static int min = Integer.MAX_VALUE;
    static int V;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] arr = new int[V + 1][V + 1];

        for(int i = 1; i <= V;  i++){
            for(int j = 1; j <= V; j++){
                if(i != j){
                    arr[i][j] = (int) 1e9;
                }
            }
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[start][end] = cost;
        }

        for(int k = 1; k <= V; k++){
            for(int i = 1; i <= V; i++){
                for(int j = 1; j <= V; j++){
                    if(i == j){
                        continue;
                    }

                    if(arr[i][j] > arr[i][k] + arr[k][j]){
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int ans = (int) 1e9;
        for(int i = 1; i <= V; i++){
            for(int j = 1; j <= V; j++){
                if(i == j){
                    continue;
                }

                if(arr[i][j] != (int) 1e9 && arr[i][j] != (int) 1e9){
                    ans = Math.min(ans, arr[i][j] + arr[j][i]);
                }
            }
        }
        System.out.println(ans == (int) 1e9 ? -1 : ans );

    }

}
