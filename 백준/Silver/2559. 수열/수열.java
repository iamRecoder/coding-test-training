import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sumArr = new int[N+1];
        int max = Integer.MIN_VALUE;

        sumArr[0] = 0;
        sumArr[1] = arr[0];
        for (int i = 1; i <= N; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i - 1];
        }


        for (int i = 0; i + K <= N; i++) {
            int sum = sumArr[K + i] - sumArr[i];
            max = Math.max(max, sum);

        }
        System.out.println(max);
    }
}
