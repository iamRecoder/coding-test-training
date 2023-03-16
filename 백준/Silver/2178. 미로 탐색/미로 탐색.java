import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] miro;
    static boolean[][] visited;
    static int[] x = {0, 1, 0, -1};
    static int[] y = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        miro = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            miro[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        bfs(0, 0);
        System.out.println(miro[N - 1][M - 1]);
    }

    public static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.offer(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] ex_ij = q.poll();
            for (int k = 0; k < x.length; k++) {
                int new_i = ex_ij[0] + x[k];
                int new_j = ex_ij[1] + y[k];
                
                if (0 <= new_i && new_i < miro.length && 0 <= new_j && new_j < miro[0].length
                        && miro[new_i][new_j] != 0 && visited[new_i][new_j] == false) {
                    miro[new_i][new_j] = miro[ex_ij[0]][ex_ij[1]] + 1;
                    visited[new_i][new_j] = true;
                    q.offer(new int[]{new_i, new_j});
                }
            }

        }
    }
}
