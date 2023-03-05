import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        int[][] xyArr = new int[M][4];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int j = 0; j < M; j++) {
            xyArr[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] sumArr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sumArr[i][j] = sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1] + arr[i - 1][j - 1];
            }
        }
        
        for (int[] xy : xyArr) {
            System.out.println(sumArr[xy[2]][xy[3]] - sumArr[xy[0] - 1][xy[3]] - sumArr[xy[2]][xy[1] - 1] + sumArr[xy[0] - 1][xy[1] - 1]);
        }
    }
}
