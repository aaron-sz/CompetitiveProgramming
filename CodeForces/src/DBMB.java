
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DBMB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        int tests = Integer.parseInt(st.nextToken());
        for(int t = 0; t < tests; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += Integer.parseInt(st.nextToken());
            }

            if(sum == s){
                pw.println("YES");
            } else if (sum > s){
                pw.println("NO");
            } else {
                // sum < s
                int diff = s - sum;
                boolean divisible = diff % x == 0 ? true : false;

                if(divisible){
                    pw.println("YES");
                } else {
                    pw.println("NO");
                }
            }
        }
        pw.close();
    }
}
