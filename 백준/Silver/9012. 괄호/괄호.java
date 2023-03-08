import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < arr.length; i++) {
            char[] a = arr[i].toCharArray();
            Stack<Character> st = new Stack();
            int index = 1;
            st.push(a[0]);
            while (index < a.length) {
                if (st.isEmpty() || st.peek() == a[index]) {
                    st.push(a[index++]);
                } else if(st.peek() == '('){
                    st.pop();
                    index++;
                } else{
                    st.push(a[index++]);
                }
            }
            if (st.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
