import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < N; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println(list.toString()
                .replace(",","")
                .replace("[","")
                .replace("]",""));

    }
}
