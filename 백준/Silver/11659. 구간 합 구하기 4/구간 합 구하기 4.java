import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sumArr = new int[N];
        sumArr[0] = arr[0];
        for (int i = 1; i < N; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(sumArr[end - 1] - sumArr[start - 1] + arr[start - 1]);
        }
    }
}
