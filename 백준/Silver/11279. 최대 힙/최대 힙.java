import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> o2 - o1);
        for(int i = 0; i < N; i++){
            int op = Integer.parseInt(br.readLine());
            if(op == 0){
                if(queue.isEmpty()) bw.write("0\n");
                else bw.write(queue.poll() + "\n");
            }else{
                queue.offer(op);
            }
        }
        bw.flush();
    }
}
