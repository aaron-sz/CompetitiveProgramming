package r800;
import java.util.*;
import java.io.*;

public class LRCandVIP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tests = Integer.parseInt(st.nextToken());
        for(int test = 0; test < tests; test++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            boolean allSame = true;

            st = new StringTokenizer(br.readLine());
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            int[] nums2 = Arrays.copyOf(nums, nums.length);

            Arrays.sort(nums);

            if(nums[0] == nums[n - 1]){
                pw.println("NO");
                continue;
            }

            int max = nums[n - 1];
            pw.println("YES");

            for(int i = 0; i < n; i++){
                if(nums2[i] == max){
                    pw.print(1 + " ");
                } else {
                    pw.print(2 + " ");
                }
            }
            pw.println("");
        }

        pw.close();
    }
}
