import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N];
        int[] P = new int[N];
        int[] dp = new int[N + 1];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
            if(i > 0)  dp[i] = Math.max(dp[i], dp[i - 1]);
            if(i + T[i] <= N){
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
        }
        if(N > 1) dp[N] = Math.max(dp[N], dp[N - 1]);

        System.out.println(dp[N]);

    }
}
