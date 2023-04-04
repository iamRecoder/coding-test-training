import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N+2];
        int M = sc.nextInt();
        for(int i = 0; i < M; i++){
            arr[sc.nextInt()] = 1;
        }
        int[] dp = new int[N+2];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= N; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
       
        int index = 0;
        int answer = 1;
        for(int i = 1; i <= N; i++){
            if(arr[i] != 1){
                index++;
            }else{
                answer *= dp[index];
                index = 0;
            }
        }
        if(index != 0) answer *= dp[index];
        System.out.println(answer);
    }
}
