import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] feeds = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = 0;
        while (count < N) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (i < count) {
                    sum += Math.min(feeds[i], feeds[count]);
                } else if (i == count) {
                    sum += feeds[count];
                } else {
                    sum += Math.min(feeds[i], feeds[count] - 1);
                }
            }
            count++;
            System.out.print(sum + " ");
        }


    }
}
