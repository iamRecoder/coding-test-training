import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int[] nx = new int[]{0, 1, 0, -1};
    static int[] ny = new int[]{-1, 0, 1, 0};
    static ArrayList<Integer> result = new ArrayList<Integer>();
    static int[][] arr;
    static boolean[][] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    cnt = 0;
                    dfs(i, j);
                    result.add(cnt);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(int size:result){
            System.out.println(size);
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        cnt++;
        for (int i = 0; i < nx.length; i++) {
            int new_x = x + nx[i];
            int new_y = y + ny[i];
            if (0 <= new_x && new_x < arr.length && 0 <= new_y && new_y < arr[0].length && arr[new_x][new_y] == 1 && !visited[new_x][new_y]) {
                dfs(new_x, new_y);
            }
        }
    }
}
