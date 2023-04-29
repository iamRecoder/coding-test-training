import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        long[] sum = new long[N + 1];
        for(int i = 1; i <= N; i++){
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        HashMap<Long, Long> map = new HashMap<>();
        for(int i = 1; i <= N; i++){
            sum[i] = sum[i] % M;
            map.put(sum[i], map.getOrDefault(sum[i], 0L) + 1);
            if(sum[i] == 0) answer++;
        }
        for(long key:map.keySet()){
            long value = map.get(key);
            if(value > 1){
                answer += value * (value - 1) / 2;
            }
        }

        System.out.println(answer);
    }
}
