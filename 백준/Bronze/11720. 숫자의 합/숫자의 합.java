import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String numStr = sc.next();
        int sum = Arrays.stream(numStr.split("")).mapToInt(Integer::parseInt).sum();
        System.out.println(sum);
    }
}