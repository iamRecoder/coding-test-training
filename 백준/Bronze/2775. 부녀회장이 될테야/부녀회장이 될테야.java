import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] dp = new int[k+1][n+1];
            long count = 0;
            for(int j = 1; j <= n; j++){
                dp[0][j] = j;
            }
            for(int j = 1; j <= k; j++){
                for(int m = 1; m <= n; m++){
                    int now = j;
                    dp[now][m] = IntStream.rangeClosed(1,m).map(s -> dp[now-1][s]).sum();
                }
            }
           
            System.out.println(dp[k][n]);

        }
    }
}
