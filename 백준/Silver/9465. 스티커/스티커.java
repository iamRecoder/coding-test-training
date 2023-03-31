import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] stickers;
    static int[][] dp, visited;

    public static void main(String[] args) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                // 값 입력받기
                int N = Integer.parseInt(br.readLine());
                stickers = new int[2][N];
                stickers[0] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                stickers[1] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                dp = new int[2][N]; // i번째가 채워진 경우
                visited = new int[2][N];
                int max = Integer.MIN_VALUE;
                calc(N);
                System.out.println(Math.max(dp[0][N-1],dp[1][N-1]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void calc(int N) {
        for (int j = 0; j < N; j++) {
            if (j == 0) {
                dp[0][j] = stickers[0][0];
//                visited[0][j] = 0;
                dp[1][j] = stickers[1][0];
//                visited[1][j] = 1;
            } else if (j == 1) {
                dp[1][j] = dp[0][j - 1] + stickers[1][j];
                dp[0][j] = dp[1][j - 1] + stickers[0][j];
            } else {
                dp[1][j] = Math.max(dp[0][j - 1] + stickers[1][j], dp[0][j - 2] + stickers[1][j]);
                dp[0][j] = Math.max(dp[1][j - 1] + stickers[0][j], dp[1][j - 2] + stickers[0][j]);
            }
        }
    }
}
