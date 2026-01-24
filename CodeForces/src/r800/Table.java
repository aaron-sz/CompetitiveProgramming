package r800;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Table {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tests = Integer.parseInt(st.nextToken());
        for(int t = 0; t < tests; t++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            int[] nums = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            int maxPairs = (n / 2);

            int goodPairs = 0;
            for(int i = 0; i < n - 1; i++){
                if(nums[i] <= h && nums[i + 1] <= l){
                    goodPairs++;
                }

                if(goodPairs == maxPairs){
                    break;
                }
            }

            pw.println(goodPairs);
        }

        pw.close();
    }
}
