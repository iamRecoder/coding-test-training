import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] stickers;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            // 값 입력받기
            int N = Integer.parseInt(br.readLine());
            stickers = new int[2][N];
            stickers[0] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            stickers[1] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            dp = new int[2][N];
            // 자기 위치를 선택했을 때 최대값을 갖게 되는 dp 배열 구하기
            calc(N);
            System.out.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
        }
    }

    static void calc(int N) {
        for (int j = 0; j < N; j++) {
            if (j == 0) {
                dp[0][j] = stickers[0][0];
                dp[1][j] = stickers[1][0];
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
