package r800;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class QuickSort {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        int tests = Integer.parseInt(st.nextToken());
        for(int t = 0; t < tests; t++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] nums = new int[n];
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < n; i++){ nums[i] = Integer.parseInt(st.nextToken()); }

            int w = 0;
            int c = 1;
            for(int i = 0; i < n; i++){
                if(nums[i] == c){
                    c++;
                    w++;
                }
            }

            int oppsNeeded = (n - w + k - 1) / k;
            pw.println(oppsNeeded);
        }

        pw.close();
    }
}
