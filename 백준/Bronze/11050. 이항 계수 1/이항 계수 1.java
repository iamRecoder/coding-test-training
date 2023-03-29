import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int nPk = IntStream.rangeClosed((n-k+1),n).reduce(1,(i,j) -> i * j);
        int r = IntStream.rangeClosed(1,k).reduce(1, (i,j) -> i * j);
        System.out.println(nPk/r);
    }
}
