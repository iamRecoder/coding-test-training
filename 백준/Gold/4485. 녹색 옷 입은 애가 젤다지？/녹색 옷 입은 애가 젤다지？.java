import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int[] dc = {0, 1, 0, -1};
    static int[] dr = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            int[][] cave = new int[N][N];
            int[][] dp = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dp[i], 1000000000);
                cave[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            dikstra(cave, dp);

            System.out.println(String.format("Problem %d: %d", index++, dp[N - 1][N - 1]));
        }

    }

    public static void dikstra(int[][] cave, int[][] dp) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        dp[0][0] = cave[0][0];
        queue.add(new Node(1, 0, cave[1][0], 0, 0));
        queue.add(new Node(0, 1, cave[0][1], 0, 0));
        while (!queue.isEmpty()) {
            Node last = queue.poll();
            if (dp[last.r][last.c] > dp[last.ex_r][last.ex_c] + last.w) {
                dp[last.r][last.c] = dp[last.ex_r][last.ex_c] + last.w;
                for (int i = 0; i < dr.length; i++) {
                    int new_r = last.r + dr[i];
                    int new_c = last.c + dc[i];
                    if (0 <= new_r && new_r < cave.length && 0 <= new_c && new_c < cave[0].length) {
                        queue.add(new Node(new_r, new_c, cave[new_r][new_c], last.r, last.c));
                    }
                }
            }

        }
    }
}

class Node implements Comparable<Node> {
    int r;
    int c;
    int w;
    int ex_r;
    int ex_c;

    Node(int r, int c, int w, int ex_r, int ex_c) {
        this.r = r;
        this.c = c;
        this.w = w;
        this.ex_r = ex_r;
        this.ex_c = ex_c;
    }

    public int compareTo(Node n) {
        return this.w - n.w;
    }
}
