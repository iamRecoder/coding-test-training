import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] score = new int[n];
        int max = 0;
        int sum = 0;
        for(int i = 0; i<n; i++){
            score[i] = sc.nextInt();
            if(score[i]> max){
                max = score[i];
            }
            sum += score[i];
        }
        System.out.println(sum*100.0/n/max);
    }
}
