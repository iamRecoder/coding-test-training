import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int[] arr = new int[n.length()];
        for(int i = 0; i <arr.length; i++){
            arr[i] = n.charAt(i) - '0';
        }

        for(int i = 0; i < arr.length; i++){
            int max = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] > arr[max]){
                    max = j;
                }
            }
            if(arr[i] < arr[max]){
                int tmp = arr[i];
                arr[i] = arr[max];
                arr[max] = tmp;
            }
        }
        System.out.println(Arrays.toString(arr).replaceAll("[\\[\\] ,]",""));

    }

}
