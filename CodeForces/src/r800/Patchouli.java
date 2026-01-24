package r800;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Patchouli {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        int tests = Integer.parseInt(st.nextToken());
        for(int t = 0; t < tests; t++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int numOdd = 0;

            // make even number odd then add it to everything else
            st = new StringTokenizer(br.readLine());
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                int r = Integer.parseInt(st.nextToken());
                nums[i] = r;
                if(r % 2 != 0 || r == 1){
                    numOdd++;
                }
            }

            if(numOdd > 0){
                pw.println(n - numOdd);
            } else {
                int minOps = Integer.MAX_VALUE;
                for(int x : nums){
                    int zeroes = Integer.numberOfTrailingZeros(x);
                    minOps = Math.min(minOps, zeroes);
                }
                pw.println(n - 1 + minOps);
            }

        }

        pw.close();
    }
}
