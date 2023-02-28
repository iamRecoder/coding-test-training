import java.util.stream.IntStream;
import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        String numToStr = Arrays.toString(numbers);
        System.out.println(numToStr);
        int sum = IntStream.rangeClosed(0,9).filter(i -> !numToStr.contains(String.valueOf(i))).sum();
        
        return sum;
    }
}