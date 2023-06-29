import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int point = -1;

        Integer[] answer = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        for (int i = N - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                int tmp = 0;
                int find = 0;
                for (int j = N - 1; j >= i; j--) {
                    if (tmp < arr[j] && arr[j] < arr[i - 1]) {
                        find = j;
                        tmp = arr[j];
                    }
                }
//                System.out.println(arr[find]+"와 " + arr[i - 1]+"를 스위치!");
                answer[find] = arr[i - 1];
                answer[i - 1] = arr[find];
                point = i;
                Arrays.sort(answer, i, N, Collections.reverseOrder());
                break;
            }
        }

        System.out.println(point == -1 ? -1 : Arrays.toString(answer).replaceAll("[\\[\\],]", ""));
    }
}
