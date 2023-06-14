import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= T; i++){
            int N = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for(int j = 1; j <= N; j++){
                String[] input = br.readLine().split(" ");
                map.put(input[1], map.getOrDefault(input[1],0) + 1);
            }
            int answer = 1;
            for(int value:map.values()){
                answer *= (value + 1);
            }
            System.out.println(answer - 1);
        }
    }
}
