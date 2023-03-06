import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int counts[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int maxCounts = Integer.MIN_VALUE;
        int sumCounts[] = new int[N+1];
        int cnt = 0;
        for(int i=1; i <= N; i++){
            sumCounts[i] = sumCounts[i-1] + counts[i-1];
        }
        for(int i = 0; i + X <= N; i++){
            int sumX = sumCounts[i+X] - sumCounts[i];
            if(sumX > maxCounts ){
                cnt = 1;
                maxCounts = sumX;
            }else if(sumX == maxCounts){
                cnt++;
            }
        }
        if(maxCounts <= 0){
            System.out.println("SAD");
        }else{
            System.out.println(maxCounts+"\n"+cnt);
        }

    }
}
