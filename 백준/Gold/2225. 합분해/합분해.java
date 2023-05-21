import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[K+1][N+1];
        for(int j = 0; j <= N; j++){
            dp[1][j] = 1;
        }
        for(int i = 2; i <= K; i++){
            int sum = 0;
            for(int j = 0; j <= N; j++){
                sum += dp[i-1][j];
                sum %= 1000000000;
                dp[i][j] = sum;
            }
        }

        System.out.println(dp[K][N]);
    }

    public static void dfs(int sum, int k){
        if(k == 0){
            if(sum == N)    count++;
            return;
        }

        for(int i = 0; i <= N; i++){
            dfs(sum + i, k - 1);
        }
    }

}
