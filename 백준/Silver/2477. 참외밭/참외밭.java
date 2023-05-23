import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[][] len = new int[5][2];
        ArrayList<int[]> list = new ArrayList<>();
        StringTokenizer st;
        for(int i = 0; i < 6; i++){
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            list.add(new int[]{dir, length});
            if(len[dir][0] == 0)    len[dir][0] = length;
            else len[dir][1] = length;
        }

        int width = 1;
        int small_width = 1;
        int[] dup = new int[2];
        int index = 0;
        for(int dir = 1;dir <= 4; dir++){
            if(len[dir][1] == 0){
                width *= len[dir][0];
            }
        }
        for(int i = 0; i < list.size(); i++){
            if(list.get(i)[0] == list.get((i+2) % list.size())[0]
                && list.get((i-1 + list.size())% list.size())[0] == list.get((i+1) % list.size())[0]){
                small_width *= list.get(i)[1];
                small_width *= list.get((i+1) % list.size())[1];
                
                break;
            }
        }
        width -= small_width;

        System.out.println(width * K);
    }
}

