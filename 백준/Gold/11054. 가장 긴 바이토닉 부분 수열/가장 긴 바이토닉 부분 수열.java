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
            int arr[] = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp_up = new int[N + 1];
            int[] dp_down = new int[N + 1];
            // 최장길이 부분 수열 문제와 원리는 동일하다.
            // 다만, 오름차순, 내림차순으로 최장길이 부분 수열을 각각 구해야 한다.
            // 구한 개수를 더한 후 값이 중복되므로 1을 빼주면 최종 dp 배열을 구할 수 있다.
            for (int i = 1; i <= N; i++) {
                dp_up[i] = dp_down[N - i + 1] = 1;
                for (int j = 1; j < i; j++) {
                    if (arr[j] < arr[i] && dp_up[j] >= dp_up[i]) {
                        dp_up[i] = dp_up[j] + 1;
                    }
                }
                for (int j = N; j > N - i + 1; j--) {
                    if (arr[j] < arr[N - i + 1] && dp_down[j] >= dp_down[N-i+1]) {
                        dp_down[N - i + 1] = dp_down[j] + 1;
                    }
                }
            }
            int[] answer = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                answer[i] = dp_up[i] + dp_down[i] - 1;
            }
            Arrays.sort(answer);
            System.out.println(answer[N]);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
