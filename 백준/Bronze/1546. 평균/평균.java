import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0, max = 0;
        for(int i = 0; i < n; i++){
            int score = Integer.parseInt(st.nextToken());
            max = Integer.max(score, max);
            sum += score;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write((float)sum*100/max/n +"");
        bw.flush();
        bw.close();
    }
}
