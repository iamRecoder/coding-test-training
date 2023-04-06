import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st;

            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(arr[i], 10000001);
                arr[i][i] = 0;
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()) - 1;
                int end = Integer.parseInt(st.nextToken()) - 1;
                int cost = Integer.parseInt(st.nextToken());
                arr[start][end] = Math.min(arr[start][end], cost);
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }

            for (int[] a : arr) {
                for (int e : a) {
                    if (e == 10000001) System.out.print(0 + " ");
                    else System.out.print(e + " ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


