import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int time = 0;
        int sum = 0;
        LinkedList<Integer> bridge = new LinkedList<>();
        for(int i = 0; i < arr.length; ){
            if(!bridge.isEmpty() && bridge.size() == w) {
                sum -= bridge.poll();
            }
            if (sum + arr[i] <= L) {
                sum += arr[i];
                bridge.add(arr[i]);
                i++;
            }else{
                bridge.add(0);
            }
            time++;
        }

        System.out.println(time + w);

    }
}
