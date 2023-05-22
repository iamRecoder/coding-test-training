import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        long[] dp = new long[D + 1];
        for (int i = 1; i <= D; i++) {
            dp[i] = i;
        }

        ArrayList<ShortCut> shortCuts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            if (end > D) continue;
            if (start + len >= end) continue;
            shortCuts.add(new ShortCut(start, end, len));
        }
        Collections.sort(shortCuts);
        int index = 0;
        for (ShortCut s : shortCuts) {
            
            if (index > s.start) continue;
            while(true){
                if(index != 0)
                    dp[index] = Math.min(dp[index], dp[index - 1] + 1);
                if(index == s.start)    break;
                else index++;
            }
            dp[s.end] = Math.min(dp[s.start] + s.len, dp[s.end]);
        }
        for (; index <= D; index++) {
            if (index == 0) continue;
            dp[index] = Math.min(dp[index], dp[index - 1] + 1);
        }

        System.out.println(dp[D]);
    }
}

class ShortCut implements Comparable<ShortCut> {
    int start, end, len;

    ShortCut(int start, int end, int len) {
        this.start = start;
        this.end = end;
        this.len = len;
    }

    public int compareTo(ShortCut other) {
        if (this.start != other.start) {
            return this.start - other.start;
        } else {
            return (this.len / (this.end - this.start + 1)) - (other.len / (other.end - other.start + 1));
        }
    }

}
