import java.util.Scanner;

// 이렇게 깔끔하게 문제를 풀 수 있도록 노오오오력하자..
public class Main {
    public static void main(String[] args){
        int N = new Scanner(System.in).nextInt();
        int[] dp = new int[N+1];
        dp[1] = 0;
        for(int i=2; i <=N; i++){
            dp[i] = dp[i-1] + 1;
            if(i % 3==0){
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}
