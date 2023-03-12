import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int left = 0, right = n - 1, cnt = 0;
        while (left < right) {
            int tmp = arr[left] + arr[right];
            if (tmp < sum) {
                left++;
            } else if (tmp > sum) {
                right--;
            } else {
                cnt++;
                left++;
                right--;
            }
        }
        System.out.println(cnt);
    }
}
