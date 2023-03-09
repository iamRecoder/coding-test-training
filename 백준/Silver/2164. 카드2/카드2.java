import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            deque.offerFirst(i+1);
        }

        int lastElement = 0;
        while (!deque.isEmpty()) {
            lastElement = deque.pollLast();
            if (!deque.isEmpty()) {
                lastElement = deque.pollLast();
                deque.offerFirst(lastElement);
            }
        }

        System.out.println(lastElement);

    }
}
