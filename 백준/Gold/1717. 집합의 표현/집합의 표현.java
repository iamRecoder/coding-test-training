import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int parent[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;  // 대표 노드 초기화
        }

        for (int i = 0; i < M; i++) {
            int question = sc.nextInt();
            int s = sc.nextInt();
            int e = sc.nextInt();
            if (question == 0) {
                union(s, e);
            } else {
                boolean result = checkSame(s, e);
                if (result) {
                    System.out.println("YES ");
                } else {
                    System.out.println("NO ");
                }
            }
            
        }
    }

    private static void union(int s, int e) {
        s = find(s);
        e = find(e);
        if (s != e) {
            parent[e] = s;
        }
    }

    private static boolean checkSame(int s, int e) {
        s = find(s);
        e = find(e);
        return s == e;
    }

    private static int find(int s) {
        if (s == parent[s])
            return s;
        else {
            return parent[s] = find(parent[s]);
        }
    }
}
