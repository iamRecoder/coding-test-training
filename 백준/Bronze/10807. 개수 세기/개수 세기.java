import java.util. *;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> count = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int m = Integer.parseInt(st.nextToken());
            count.put(m, count.getOrDefault(m,0) + 1);
        }
        int v = Integer.parseInt(br.readLine());
        System.out.println(count.getOrDefault(v,0));
    }
}