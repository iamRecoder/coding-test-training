import java.util.*;
import java.io.*;

public class Main {
	static int count = 0;
	static boolean[] visited;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		graph = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		StringTokenizer st;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph[s].add(e);
			graph[e].add(s);
		}
		
		visited[1] = true;
		dfs(1);
		System.out.println(count);
	}
	
	public static void dfs(int start) {
		for(int end : graph[start]) {
			if(!visited[end]) {
				count++;
				visited[end] = true;
				dfs(end);
			}
		}
		
	}

}
