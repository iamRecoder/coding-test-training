import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        arr[1] = 1;
        for(int i = 2; i <= N; i++){
            if(i == 2){
                arr[i] = 3;
                continue;
            }
            arr[i] = (arr[i-2] * 2 + arr[i-1] ) % 10007;
        }

        System.out.println(arr[N]);
    }
}