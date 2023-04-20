import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] recur;
    static int cnt = 0;
    public static void main(String[] args){
        int N = new Scanner(System.in).nextInt();
        recur =  new int[N+1];
        fibRecur(N);
        System.out.println(cnt);
        System.out.print(N - 2);
    }

    public static void fibRecur(int N){
        if( N == 1 || N == 2){
            cnt++;
            return;
        }else{
            recur[N] = recur[N] + 1;
            fibRecur(N-1);
            fibRecur(N-2);
        }
    }


}
