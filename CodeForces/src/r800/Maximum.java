package r800;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Maximum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int q = Integer.parseInt(st.nextToken());
        for(int t = 0; t < q; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            int lowestK = Integer.MAX_VALUE;
            for(int i = 0; i < n - 1; i++){
                int current = nums[i];
                int next = nums[i + 1];

                int largest = Math.max(current, next);
                int k = largest - 1;

                lowestK = Math.min(lowestK, k);
            }

            pw.println(lowestK);
            
        }

        pw.close();
    }
}
