import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(i -> i % divisor == 0).sorted().toArray();
        int[] noElement = {-1};
        return answer.length == 0 ? noElement : answer;
    }
}