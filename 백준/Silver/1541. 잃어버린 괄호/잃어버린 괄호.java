import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split("-");
        long sum = Arrays.stream(exp[0].split("\\+")).mapToLong(Long::parseLong).sum();
        for(int i = 1; i < exp.length; i++){
            sum -= Arrays.stream(exp[i].split("\\+")).mapToLong(Long::parseLong).sum();
        }
        System.out.println(sum);
    }
}
