package r800;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PrefixMax {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        int tests = Integer.parseInt(st.nextToken());

        for(int test = 0; test < tests; test++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int[] nums = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            int maxVal = 0;
            int maxIdx = 0;
            for(int i = 0; i < n; i++){
                if(nums[i] > maxVal){
                    maxVal = nums[i];
                    maxIdx = i;
                }
            }

            int temp = nums[0];
            nums[maxIdx] = temp;
            nums[0] = maxVal;

            int maxSum = 0;
            for(int i = 1; i <= n; i++){ 
                int[] prefix = new int[i];
                for(int j = 0; j < i; j++){
                    prefix[j] = nums[j];
                }
                maxSum += max(prefix);
            }

            pw.println(maxSum);
        }

        pw.close();
    }

    static int max(int[] arr){
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
