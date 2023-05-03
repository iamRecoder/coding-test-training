import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[N];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < N; i++) {
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                result[st.pop()] = arr[i];
            }
            st.push(i);
        }
        System.out.println(Arrays.toString(result).replaceAll("[,\\[\\]]",""));
    }
}
