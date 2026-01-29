import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatingFunction {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());

        if(num % 2 == 0){
            System.out.println(num / 2);
        } else {
            System.out.println((num / 2 + 1) * -1);
        }
    }
}
