import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String DNA = br.readLine();
        char[] limitChar = new char[]{'A', 'C', 'G', 'T'};
        int[] limitCnt = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] curCnt = new int[4];

        int answer = 0;
        // 초기 문자열의 curCnt를 구한다.
        for (int i = 0; i < 4; i++) {
            int len = DNA.substring(0,P).length() - DNA.substring(0,P).replace(String.valueOf(limitChar[i]), "").length();
            curCnt[i] = len;
        }

        for (int i = P-1; i < S; i++) {
            if(i != P-1){
                // 이전 인덱스 값 제거
                int j = Arrays.binarySearch(limitChar, DNA.charAt(i-P));
                curCnt[j]--;

                // 현재 인덱스 값 추가
                j = Arrays.binarySearch(limitChar, DNA.charAt(i));
                curCnt[j]++;
            }
            int count = (int) IntStream.range(0, 4).filter(k -> limitCnt[k] <= curCnt[k]).count();
            if (count == 4) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
