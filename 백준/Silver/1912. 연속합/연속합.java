import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = Integer.MIN_VALUE;
        int sum = 0;

        int left = 0;
        for (int right = 0; right < n; right++) {
            if (sum > 0 && arr[right] < -1 * sum) {
                left = right;
                sum = 0;
            } else if (sum < 0 ) {
                left = right -1;
                sum = arr[right];
                max = Math.max(max, sum);
            } else {
                sum += arr[right];
                max = Math.max(max, sum);

            }

        }
        System.out.println(max);


    }
}
