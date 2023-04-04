import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] consultings = new int[N+1][2];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            consultings[i][0] = Integer.parseInt(st.nextToken());   // 기간
            consultings[i][1] = Integer.parseInt(st.nextToken());   // 금액
        }

        int[] dp = new int[N+1];
        for(int i = 1; i <= N; i++){
            int after = i-1 +consultings[i][0];
            if(after <= N) {
                dp[after] = Math.max(dp[after], dp[i - 1] + consultings[i][1]);
            }
            dp[i] = Math.max(dp[i], dp[i-1]);
        }
        System.out.println(dp[N]);
    }
}
