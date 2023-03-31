import java.util.Scanner;

public class Main {
    static int N, M, max;
    static int[][] arr;
    static int[][] temp;

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N + 1][M + 1];
        temp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        dfs(0);
        System.out.println(max);
    }

    public static void dfs(int count){
        // 울타리가 3개 설치된 경우
        if(count == 3){
            // temp로 arr 옮기기
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= M; j++){
                    temp[i][j] = arr[i][j];
                }
            }
            // 각 바이러스의 위치에서 전파 진행
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= M; j++){
                    if(temp[i][j] == 2){
                        virus(i,j);
                    }
                }
            }
            // 현재 안전 영역 계삭
            int now = getSafeCnt();
            max = Math.max(max, now);   // 최대 안전 영역 구하기
            return;
        }

        // 빈 공간에 울타리 설치
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(arr[i][j]  == 0){
                    arr[i][j] = 1;
                    count += 1;
                    dfs(count);
                    arr[i][j] = 0;
                    count -= 1;
                }
            }
        }
    }

    // 바이러스를 사방으로 퍼뜨리기
    private static void virus(int x, int y) {
        for(int i = 0; i < 4; i++){
            int new_x = x + dx[i];
            int new_y = y + dy[i];
            if(0 < new_x && new_x <= N && 0 < new_y && new_y <= M){
                if(temp[new_x][new_y] == 0){
                    temp[new_x][new_y] = 2;
                    virus(new_x, new_y);
                }
            }
        }
    }

    private static int getSafeCnt() {
        int cnt = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(temp[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
