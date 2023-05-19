import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < word.length(); i++){
            int key = word.charAt(i) - 'a';
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            sb.append(map.getOrDefault(i, 0)).append(" ");
        }
        System.out.println(sb);
    }
}
