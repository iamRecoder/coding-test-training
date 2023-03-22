import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            boolean[][] visited = new boolean[N + 1][];
            for (int i = 0; i <= N; i++) {
                visited[i] = new boolean[N + 1];
            }

            int currentVertex = 0;
            int forLoopCount = (N) * (N - 1) / 2;
            visited[1][N] = visited[N][1] = true;
            while (forLoopCount-- > 0) {
                for (int i = 1; i <= N; i++) {
                    if (i == currentVertex || visited[currentVertex][i]) continue;
                    visited[currentVertex][i] = visited[i][currentVertex] = true;
                    currentVertex = i;
                    break;
                }
                System.out.print("a" + currentVertex + " ");
            }
            System.out.print("a1");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
