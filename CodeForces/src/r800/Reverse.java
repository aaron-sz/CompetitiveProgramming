
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Reverse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        int tests = Integer.parseInt(st.nextToken());

        for(int t = 0; t < tests; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            int currMax = n;
            int idxToChange = n;

            int[] vals = new int[n + 1];
            for(int i = 0; i < n; i++){
                vals[nums[i]] = i;
            }

            for(int i = 0; i < n; i++){
                if(nums[i] == currMax){
                    currMax--;
                } else {
                    idxToChange = i;
                    break;
                }
            }

            if(idxToChange == n){
                for(int x : nums){
                    pw.print(x + " ");
                }

                pw.println();
            } else {
                // do the swap
                int[] newArray = new int[n];
                int start = idxToChange;
                int end = vals[currMax];
                for(int i = 0; i < start; i++){
                    newArray[i] = nums[i];
                }

               // swap part
                int endPtr = end;
                for(int i = start; i <= end; i++){
                    newArray[i] = nums[endPtr];
                    endPtr--;
                }

                for(int i = end + 1; i < n; i++){
                    newArray[i] = nums[i];
                }

                for(int x : newArray){
                    pw.print(x + " ");
                }

                pw.println();
               
            }
        }

        pw.close();
    }
}
