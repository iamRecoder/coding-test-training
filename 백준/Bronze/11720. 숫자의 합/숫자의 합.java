import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int sum = 0;
        String line = br.readLine();

        for(int i = 0; i < num; i++){
            sum += line.charAt(i) - '0';
        }
        System.out.println(sum);
    }
}
