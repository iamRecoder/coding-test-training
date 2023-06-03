import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static int N;
    static String answer = "";
    public static void main(String[] args) {
        N = new Scanner(System.in).nextInt();
        backtracking("");
        System.out.println(answer);
    }

    static void backtracking(String input){

        if(!answer.equals(""))    return;

        if(input.length() == N)    answer = input;

        for(int i = 1; i <= 3; i++){
            if(isGood(input + i)){
                backtracking(input + i);
            }
        }
    }

    static boolean isGood(String input){
        for(int i = 1; i <= input.length()/2; i++){
            String sub = input.substring(input.length() - i);
            String sub2 = input.substring(input.length() - 2 * i, input.length() - i);
            if(sub.equals(sub2)){
                return false;
            }
        }
        return true;
    }

}
