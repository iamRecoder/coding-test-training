import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> st = new Stack();
        StringBuilder sb = new StringBuilder();
        int index = 0;  // push된 마지막 수
        for(int i = 0; i < n; i++){
            if(index < arr[i]){
                while(index < arr[i]){
                    st.push(++index);
                    sb.append("+\n");
                }
                st.pop();
                sb.append("-\n");
            }else{
                int top = st.pop();
                if( top == arr[i]){
                    sb.append("-\n");
                }else{
                    sb.delete(0,sb.length());
                    sb.append("NO");
                    break;
                }

            }
        }
        System.out.println(sb.toString());

    }
}
