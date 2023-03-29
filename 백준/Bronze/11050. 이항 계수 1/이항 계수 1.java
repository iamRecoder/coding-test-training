import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int nPk = IntStream.rangeClosed((n - k + 1), n).reduce(1, (i, j) -> i * j);
        int r = IntStream.rangeClosed(1, k).reduce(1, (i, j) -> i * j);
        System.out.println(nPk / r);
    }
}
