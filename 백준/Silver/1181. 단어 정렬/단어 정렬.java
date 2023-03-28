import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<String>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        String[] arr = set.toArray(new String[0]);
        Arrays.sort(arr, (s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length();
            } else {
                return s1.compareTo(s2);
            }
        });
        System.out.println(String.join("\n", arr));
    }
}
