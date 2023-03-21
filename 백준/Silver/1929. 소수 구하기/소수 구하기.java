import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] isPrimeNumber = new boolean[N+1];
        Arrays.fill(isPrimeNumber,true);
        isPrimeNumber[0] = false;
        isPrimeNumber[1] = false;
        for(int i = 2; i <= Math.sqrt(N); i++ ){
            for(int j =2; i*j <= N; j++){
                isPrimeNumber[i*j] = false;
            }
        }
        for(int i = M; i <= N; i++){
            if(isPrimeNumber[i])
                System.out.println(i);
        }
    }
}
