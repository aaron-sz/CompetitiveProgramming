import java.io.*;
import java.util.*;

public class MEXReordering {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for(int test = 0; test < t; test++){
            int n;
            int[] nums;

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            nums = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(br.readLine());
            }


        }
    }

    static int mex(int[] arr){
        int mex = 0;
        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == i){
                mex++;
            }
        }

        return mex;
    }
}
