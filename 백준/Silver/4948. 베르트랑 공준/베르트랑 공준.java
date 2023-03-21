import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            boolean[] isPrime = new boolean[2 * n + 1];
            Arrays.fill(isPrime, true);
            for (int i = 2; i <= Math.sqrt(2 * n); i++) {
                if (isPrime[i] == false) continue;
                for (int j = 2; j * i <= 2 * n; j++) {
                    isPrime[j * i] = false;
                }
            }
            int cnt = (int) IntStream.rangeClosed(n + 1, 2 * n).filter(i -> isPrime[i]).count();
            sb.append(cnt + "\n");
            n = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
    }
}
