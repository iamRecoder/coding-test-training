import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        boolean[] isPrime = new boolean[(int) Math.sqrt(B) + 1];
        Arrays.fill(isPrime, true);

        // 소수인지 체크 하기
        for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
            if (isPrime[i]) {
                for (int j = i + i; j < isPrime.length; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }

        // 소수일 때만 제곱을 하면서 개수 세기
        long count = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                long temp = i;
                while ((double)i <= (double)B / (double)temp) {
                    if ((double)i >= (double)A / (double)temp) {
                        count++;
                    }
                    temp = temp * i;
                }
            }
        }
        System.out.println(count);
    }
}

