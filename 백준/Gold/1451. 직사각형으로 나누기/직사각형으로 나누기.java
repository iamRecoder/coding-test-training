import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long max = 0;
    static int N;
    static int M;
    static int[][] arr;
    static long[][] sum;

    public static void main(String[] args) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N][M];
            for (int i = 0; i < N; i++) {
                arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }
            sum = new long[N][M];
            sum[0][0] = arr[0][0];
            for (int j = 1; j < M; j++) {
                sum[0][j] = sum[0][j - 1] + arr[0][j];
            }
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (j == 0) sum[i][j] = sum[i - 1][j] + arr[i][j];
                    else sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + arr[i][j];
                }
            }

            divideWidth();
            divideHeight();
            divideWidthAndHeight();
            System.out.println(max);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void divideWidthAndHeight() {
        if (N < 2) return;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                // 각각 작은 직사각형의 합의 곱을 구하고 최대값 갱신하기
                max = Math.max(max, sum[i][M-1] * (sum[j][M-1] - sum[i][M-1]) * (sum[N-1][M-1] - sum[j][M-1]));
            }
        }
    }

    private static void divideHeight() {
        if (M < 2) return;
        for (int i = 0; i < M - 2; i++) {
            for (int j = i + 1; j < M - 1; j++) {
                max = Math.max(max, sum[N-1][i] * (sum[N-1][j] - sum[N-1][i]) * (sum[N-1][M-1] - sum[N-1][j]));
            }
        }
    }

    private static void divideWidth() {
        if (N < 2 && M < 2) return;
        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < M - 1; j++){
                // 4가지 경우 모두 계산하기
                max = Math.max(max, sum[i][j] * (sum[N-1][j] - sum[i][j]) * (sum[N-1][M-1] - sum[N-1][j]));
                max = Math.max(max, sum[N-1][j] * (sum[i][M-1] - sum[i][j]) * (sum[N-1][M-1] - sum[N-1][j] - sum[i][M-1] + sum[i][j]));
                max = Math.max(max, sum[i][j] * (sum[i][M-1] - sum[i][j]) * (sum[N-1][M-1] - sum[i][M-1]));
                max = Math.max(max, sum[i][M-1] * (sum[N-1][j] - sum[i][j]) * (sum[N-1][M-1] - sum[N-1][j] - sum[i][M-1] + sum[i][j]));
            }
        }

    }
}
