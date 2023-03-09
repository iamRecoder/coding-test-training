import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.offer(i+1);
        }

        int lastElement = 0;
        while (!queue.isEmpty()) {
            lastElement = queue.poll();
            if (!queue.isEmpty()) {
                lastElement = queue.poll();
                queue.offer(lastElement);
            }
        }

        System.out.println(lastElement);

    }
}
