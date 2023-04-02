import java.util.Scanner;

public class Main {
    static int N;
    static int min = Integer.MAX_VALUE;
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dfs(N);
        System.out.println(min);

    }

    static void dfs(int K){
        if(cnt > min)
            return;
        if(K == 1){
            min = Math.min(min,cnt);
        }else if(K == N){
            if(K % 3 == 0){
                cnt = 1;
                dfs(K/3);
            }
            if(K % 2 == 0){
                cnt = 1;
                dfs(K/2);
            }
            cnt = 1;
            dfs(K-1);
        }else{
            int temp = cnt;
            if(K % 3 == 0){
                cnt = temp + 1;
                dfs(K/3);
            }
            if(K % 2 == 0){
                cnt = temp + 1;
                dfs(K/2);
            }
            cnt = temp + 1;
            dfs(K-1);
        }
    }
}
