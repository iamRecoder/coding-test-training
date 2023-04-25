import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] prereq;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        count = new int[N + 1];
        prereq = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            prereq[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            prereq[start].add(end);
        }

//        for (int i = 1; i <= N; i++) {
//            if(count[i] == 0){
//                dfs(i);
//            }
//        }

        for (int i = 1; i <= N; i++) {
            count[i] = Math.max(1, count[i]);
            for (int end : prereq[i]) {
                if (count[end] <= count[i]) {
                    count[end] = count[i] + 1;
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (
                int i = 1;
                i <= N; i++) {
            sb.append(count[i]).append(" ");
        }
        System.out.println(sb);
    }

    static void dfs(int start) {
        count[start] += 1;
        for (int end : prereq[start]) {
            count[end] = Math.max(count[start], count[end]);
            if (count[end] <= count[start]) {
                dfs(end);
            }
        }
    }
}
