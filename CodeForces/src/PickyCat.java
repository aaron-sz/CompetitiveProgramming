import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PickyCat {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int q = Integer.parseInt(st.nextToken());
        for(int t = 0; t < q; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            if(n <= 2){
                pw.println("YES");
                continue;
            }
            
            int[] nums = new int[n];
            int idx1 = Math.abs(Integer.parseInt(st.nextToken()));
            nums[0] = idx1;

            int numGreater = 0;
            int numLess = 0;

            for(int i = 1; i < n; i++){
                nums[i] = Math.abs(Integer.parseInt(st.nextToken()));
                if(nums[i] > idx1){
                    numGreater++;
                } else {
                    numLess++;
                }
            }

            if(numLess > (n / 2)){
                pw.println("NO");
            } else {
                pw.println("YES");
            }

        }

        pw.close();
    }
}
