import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            char[] a = br.readLine().toCharArray();
            Stack<Character> st = new Stack();
            int index = 0;
            while (index < a.length) {
                if (st.isEmpty() || a[index] == '(') {
                    st.push(a[index++]);
                } else {
                    if(st.peek() == '(') {
                        st.pop();
                        index++;
                    }else{
                        st.push(a[index++]);
                    }
                }
            }
            System.out.println(st.isEmpty() ? "YES" : "NO");
        }
    }
}
