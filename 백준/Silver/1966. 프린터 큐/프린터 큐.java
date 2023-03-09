import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(str.nextToken());
            int M = Integer.parseInt(str.nextToken());
            Queue<Integer> q = new LinkedList<>();
            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                q.offer(Integer.parseInt(str.nextToken()));
            }

            int cnt = 0;
            int check = 0;
            while (!q.isEmpty()) {

                check = q.poll();     // 검사할 요소 하나 빼기
                boolean isPrior = true;
                for (int k = 0; k < q.size(); k++) {  // 돌면서 검사 진행
                    int tmp = q.poll(); // 하나씩 빼와서 비교
                    if (check < tmp) {
                        isPrior = false;
                    }
                    q.offer(tmp);
                }
                if (isPrior) {
                    cnt++;
                    if (M == 0) {
                        System.out.println(cnt);
                        break;
                    }
                    M--;
                } else {
                    q.offer(check);
                    if (M == 0) {
                        M = q.size() - 1;
                    } else {
                        M--;
                    }
                }
            }


        }
    }
}
