import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String rank = "BSGPD";

            int N = Integer.parseInt(br.readLine());
            int[] rankLimit = new int[4];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                rankLimit[i] = Integer.parseInt(st.nextToken());
            }
            String input = br.readLine();
            int[] day = new int[input.length()];
            int index = rank.indexOf(input.charAt(0));
            if (index < 4)
                day[0] = rankLimit[index] - 1;
            else
                day[0] = rankLimit[3];
            for (int i = 1; i < input.length(); i++) {
                index = rank.indexOf(input.charAt(i));
                int max = 0;
                if (index < 4) {
                    max = rankLimit[index] - 1;
                    day[i] = max - day[i - 1];
                } else {
                    day[i] = rankLimit[3];
                }
            }
            System.out.println(Arrays.stream(day).sum());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
