import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int trees[] = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if(max < trees[i])  max = trees[i];
        }
        long sum = 0;
        int min = 0;
        while (min < max) {
            int mid = (min + max) / 2;
            sum = 0;
            for (int tree : trees) {
                sum += mid < tree ? tree - mid : 0;
            }
            
            if (sum < M){
                max = mid;
            }else{
                min = mid + 1;
            }
        }
        System.out.println(min - 1);

    }
}
