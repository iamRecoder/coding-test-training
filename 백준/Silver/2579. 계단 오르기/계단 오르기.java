import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N+2];
        int[] dp = new int[N+2];

        for(int i = 1; i <= N; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = stairs[1];
        dp[2] = dp[1] + stairs[2];
        for(int i = 3; i <= N; i++){
            // i-1을 안 밟은 경우와 i-2를 안 밟은 경우를 구해서 최대 값 갱신
            dp[i] = dp[i-2] + stairs[i];
            dp[i] = Math.max(dp[i], dp[i-3] + stairs[i-1] + stairs[i]);
        }
        System.out.println(dp[N]);
    }
}
