import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        String S = new Scanner(System.in).next();
        StringTokenizer st1 = new StringTokenizer(S,"1");
        StringTokenizer st0 = new StringTokenizer(S,"0");
        System.out.println(Math.min(st0.countTokens(),st1.countTokens()));

    }
}
