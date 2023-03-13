import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int sum = 0, max_cnt = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            int cnt = hashMap.getOrDefault(arr[i], 0) + 1;
            if (cnt > max_cnt) {
                queue.clear();
                queue.offer(arr[i]);
                max_cnt = cnt;
            } else if (cnt == max_cnt) {
                queue.offer(arr[i]);
            }
            hashMap.put(arr[i], cnt);
        }
        int avg = (int) Math.round((double)sum / n);
        Arrays.sort(arr);
        int mid = arr[(n - 1) / 2];

        int mod = queue.poll();
        if (!queue.isEmpty()) mod = queue.poll();
        int range = arr[n - 1] - arr[0];
        System.out.println(avg + "\n" + mid + "\n" + mod + "\n" + range);
    }
}
