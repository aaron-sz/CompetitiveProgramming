import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ReplaceAndSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        int tests = Integer.parseInt(st.nextToken());
        for(int t = 0; t < tests; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] a = new int[n + 5];
            for(int i = 1; i <= n; i++){ a[i] = Integer.parseInt(st.nextToken()); }

            st = new StringTokenizer(br.readLine());
            int[] b = new int[n + 5];
            for(int i = 1; i <= n; i++){ b[i] = Integer.parseInt(st.nextToken()); }

            a[n + 1] = 0;

            for(int i = n; i > 0; i--){
                int bestFromRight = Math.max(a[i + 1], b[i]);
                a[i] = Math.max(a[i], bestFromRight);
            }

            int[] prefix = new int[n + 5];
            prefix[0] = 0;
            for(int i = 1; i <= n; i++){
                prefix[i] = prefix[i - 1] + a[i];
            }

            for(int t2 = 0; t2 < q; t2++){
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                int sum = 0;
                // for(int i = l; i <= r; i++){
                //     sum += a[i];
                // }

                sum += prefix[r] - prefix[l - 1];

                pw.print(sum + " ");
            }

            pw.println();
        }

        pw.close();
    }
}
