import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        });
        for (int i = 0; i < N; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            queue.add(arr);
        }
        int cnt = 0;
        int end = 0;
        int[] tmp;
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            if (tmp[0] >= end) {
                cnt++;
                end = tmp[1];
            } 
        }
        System.out.println(cnt);
    }

}
