import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long mod = Math.max(A,B) % Math.min(A,B);
        long min = Math.min(A,B);
        while(mod != 0){
            long tmp = mod;
            mod = min % mod;
            min = tmp;
        }
        StringBuilder sb = new StringBuilder();
        LongStream.range(0, min).forEach(i -> sb.append("1"));
        System.out.println(sb);
    }
}
