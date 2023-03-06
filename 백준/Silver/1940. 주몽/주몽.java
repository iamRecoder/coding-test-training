import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] src = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int left = 0, right = src.length - 1;
        int sum = 0, cnt = 0;
        while (left < right) {
            if (src[left] + src[right] == M) {    // M이면
                cnt++;
                left++;
                right--;
            } else if (src[left] + src[right] < M) { // M보다 작으면
                left++;
            } else {  // M보다 크면
                right--;
            }
        }
        System.out.println(cnt);
    }
}
