import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int N = new Scanner(System.in).nextInt();
        int[] numbers = new int[9];
        while(N > 0){
            int q = N % 10;
            if(q == 9) q = 6;
            numbers[q]++;
            N /= 10;
        }
        numbers[6] = (int) Math.ceil(numbers[6]/2.0);

        int max = Arrays.stream(numbers).max().orElse(0);
        System.out.println(max);
    }
}
