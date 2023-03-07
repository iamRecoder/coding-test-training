import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] pies = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] newPies = new int[N + K - 1];
        System.arraycopy(pies, 0, newPies, 0, N);
        System.arraycopy(pies, 0, newPies, N, K - 1);

        long sum = IntStream.range(0, K).map(i -> newPies[i]).sum();
        long max = sum;
        for (int i = K; i < N + K - 1; i++) {
            sum = sum - newPies[i - K] + newPies[i];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
