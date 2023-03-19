import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        for (int j = coins.length - 1; j >= 0; j--) {
            if (K == 0) break;
            if (K >= coins[j]) {
                while (K >= coins[j]) {
                    K -= coins[j];
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
