import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
       
        System.out.println("1".repeat((int)min));
    }
}
