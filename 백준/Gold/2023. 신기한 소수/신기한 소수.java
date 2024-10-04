import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);
    }

    public static void DFS(int num, int jarisu){
        if(isPrime(num)) {
            if (jarisu == N) {
                System.out.println(num);
            } else {
                for (int i = 1; i < 10; i+=2) {
                    DFS(num * 10 + i, jarisu + 1);
                }
            }
        }
    }


    public static boolean isPrime(int num){
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}