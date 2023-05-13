import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        HashMap<Integer,Integer> rank = new HashMap<>();
        int[][] arr = new int[N + 1][2];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            rank.put(i, 1);
            for(int k : rank.keySet()){
                if(arr[k][0] < arr[i][0] &&  arr[k][1] < arr[i][1]){
                    rank.put(k, rank.get(k) + 1);
                }else if(arr[k][0] > arr[i][0] && arr[k][1] > arr[i][1]){
                    rank.put(i, rank.get(i) + 1);
                }
            }
        }

        for(int i = 1; i <= N; i++)
        {
            System.out.print(rank.get(i) + " ");
        }
    }
}
