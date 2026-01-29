package r900;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AvtoBus {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        for(int t = 0; t < tests; t++){
            long wheels = Long.parseLong(br.readLine());

            if(wheels % 2 != 0 || wheels < 4){
                System.out.println(-1);
            } else {
                long min = wheels / 6;
                long max = wheels / 4;

                long minDiff = wheels - min * 6;
                if(minDiff != 0){
                    min++;
                }
                
                long maxDiff = wheels - max  * 4;
                if(maxDiff != 2 && maxDiff != 0){
                    max++;
                }

                System.out.println(min + " " + max);
            }
        }
    }
}