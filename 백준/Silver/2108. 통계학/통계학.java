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
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int avg = (int) Math.round(Arrays.stream(arr).average().getAsDouble());
        Arrays.sort(arr);
        int mid = arr[(n - 1) / 2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int max_cnt = 0;
        for(int e : arr) {
            int cnt = hashMap.getOrDefault(e, 0) + 1;
            if (cnt > max_cnt) {
                queue.clear();
                queue.offer(e);
                max_cnt = cnt;
            } else if (cnt == max_cnt) {
                queue.offer(e);
            }
            hashMap.put(e, cnt);
        };
        int mod = queue.poll();
        if (!queue.isEmpty()) mod = queue.poll();
        int range = arr[arr.length - 1] - arr[0];
        System.out.println(avg + "\n" + mid + "\n" + mod + "\n" + range);
    }
}
