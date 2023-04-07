import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            q.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!q.isEmpty()){
            for(int i = 0; i < K-1; i++){
                q.offer(q.poll());
            }
            sb.append(q.poll()+", ");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append(">");
        System.out.println(sb);
    }
}
