package r800;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ShiftedMex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tests = Integer.parseInt(st.nextToken());
        for(int t = 0; t < tests; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            long[] nums = new long[n];
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                nums[i] = Long.parseLong(st.nextToken());
            }

            Arrays.sort(nums);

            int longestChain = 1;
            int currentChain = 1;
            for(int i = 0; i < n - 1; i++){
                if((nums[i] + 1) == nums[i + 1]){
                    currentChain++;
                } else if(nums[i] == nums[i + 1]){
                    continue;
                } else {
                    currentChain = 1;
                }

                longestChain = Math.max(longestChain, currentChain);
            }

            pw.println(longestChain);
        }

        pw.close();
    }
}
