import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sortedArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = sortedArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> rank = new HashMap<>();
        int order = 0;
        for(int e:sortedArr){
            if(!rank.containsKey(e))
                rank.put(e,order++);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            int index = rank.get(arr[i]);
            sb.append(index + " ");
        }
        System.out.println(sb);
    }
}
