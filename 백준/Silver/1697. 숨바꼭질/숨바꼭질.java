import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int cnt = 0, min = Integer.MAX_VALUE;
    static int N;
    static int M;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        if (N == M) min = 0;
        else bfs(N);
        System.out.println(min);
    }

    static void bfs(int now) {
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{now, 0});
        while (!q.isEmpty()) {
            int[] ex = q.poll();
            int walk_back = ex[0] - 1;
            int walk_front = ex[0] + 1;
            int move = 2 * ex[0];
            boolean canWalkBack = 0 <= walk_back && walk_back <= 100000;
            boolean canWalkFront = 0 <= walk_front && walk_front <= M;
            boolean canMove = 2 <= move && move <= 100000;
            cnt = ex[1] + 1;
            if (cnt < min && (walk_back == M || walk_front == M || move == M)) {
                min = Math.min(min, cnt);
            } else if (cnt < min) {
                if (canWalkBack && !visited[walk_back]) {
                    q.offer(new int[]{walk_back, cnt});
                    visited[walk_back] = true;
                }
                if (canWalkFront && !visited[walk_front]) {
                    q.offer(new int[]{walk_front, cnt});
                    visited[walk_front] = true;
                }
                if (canMove && !visited[move]) {
                    q.offer(new int[]{move, cnt});
                    visited[move] = true;
                }
            }
            
        }
    }
}
