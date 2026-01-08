import java.io.*;
import java.util.*;

public class StaticRangeSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] seq = new int[n];

        long[] prefix = new long[n + 1];

        for(int i = 0; i < n; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            prefix[i + 1] = prefix[i] + seq[i];
        }


        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            pw.println(prefix[r] - prefix[l]);
        }

        pw.close();
    }
}
