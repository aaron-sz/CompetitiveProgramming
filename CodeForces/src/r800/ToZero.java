package r800;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ToZero {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int q = Integer.parseInt(st.nextToken());
        for(int t = 0; t < q; t++){
            st = new StringTokenizer(br.readLine());
            long n = Integer.parseInt(st.nextToken());
            long k = Integer.parseInt(st.nextToken());

            long largestEven;
            long largestOdd;

            if(k % 2 == 0){
                largestEven = k;
                largestOdd = k - 1;
            } else {
                largestEven = k - 1;
                largestOdd = k;
            }

            long opps = 0;

            // make n even

            if(n % 2 != 0){
                n -= largestOdd;
                opps++;
            }

            if(n % 2 == 0){
                long x = n / largestEven;
                long remainder = n % largestEven;

                if(remainder > 0){
                    opps++;
                }

                opps += x;
            }

            System.out.println(opps);
        }
    }
}
