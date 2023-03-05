import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int left = 0, right = 0;
        int count = 1, sum = 0;
        while(right < N){
            if(sum == N){   // sum == N
                sum += ++right;
                sum -= left++;
                count++;
            }else if(sum < N){     // sum < N
                sum += ++right;
            }else{          // sum > N
                sum -= left++;
            }
        }
        System.out.println(count);
    }
}
