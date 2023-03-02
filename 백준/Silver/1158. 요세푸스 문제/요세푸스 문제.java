import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(q.size() != 1){
            for(int i = 0; i < K - 1; i++){
                q.offer(q.poll());
            }
            sb.append(q.poll() + ", ");
        }

        sb.append(q.poll() + ">");

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
Queue의 메서드
- offer(): 큐 맨 뒤에 값 삽입. 성공 시 true, 실패 시 false 반환
- poll(): 큐 맨 앞에 있는 값 반환 후 삭제. 큐가 비어 있을 경우 null 반환
- peek(): 큐 맨 앞에 있는 값 반환. 큐가 비어 있을 경우 null 반환
- clear(): 큐 비우기

Deque의 메서드
- offerFirst(): 맨 앞에 원소 삽입. 삽입 성공 시 true, 용량 제한에 걸리는 경우 false 반환
- offerLast(): 맨 뒤에 원소 삽입. 삽입 성공 시 true, 용량 제한에 걸리는 경우 false 반환
- pollFirst(): 맨 앞의 원소 제거 후 반환. 제거 성공 시 true, 덱이 비어 있을 경우 null 반환
- pollLast(): 맨 뒤의 원소 제거 후 반환. 제거 성공 시 true, 덱이 비어 있을 경우 null 반환
- peekFirst(): 맨 앞의 원소를 반환. 덱이 비어 있을 경우 null 반환
- peekLast(): 맨 뒤의 원소를 반환. 덱이 비어 있을 경우 null 반환
 */