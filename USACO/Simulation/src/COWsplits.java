import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class COWsplits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        int tests = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for(int t = 0; t < tests; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if(s.length() % 2 == 0 && (s.substring(0, s.length() / 2).equals(s.substring(s.length() / 2, s.length())))){
                pw.println(1);
                for(int i = 0; i < n * 3; i++){
                    if(i > 0){
                        pw.print(' ');
                    }
                    pw.print(1);
                }
                pw.println();
                continue;

            } else if (n * 3 % 2 != 0 ) {
                pw.println(-1);
                continue;

            } else {
                int[] ans = new int[3 * n];
                Arrays.fill(ans, 1);

                for(int i = 0; i < n /2 ; i++){
                    int L_idx = i * 3;
                    int R_idx = (i + n/2) * 3;

                    String l = s.substring(L_idx, L_idx + 3);
                    String r = s.substring(R_idx, R_idx + 3);
                    
                    if(l.equals(r)){
                        continue;
                    }

                    if(l.substring(1,3).equals(r.substring(0,2))){
                        ans[L_idx] = 2;
                        ans[R_idx + 2] = 2;
                    } else if(l.substring(0,2).equals(r.substring(1,3))){
                        ans[L_idx + 2] = 2;
                        ans[R_idx] = 2;
                    }
                }

                pw.println(2);
                for(int i = 0; i < n * 3; i++){
                    if(i > 0){
                        pw.print(' ');
                    }
                    pw.print(ans[i]);
                }
                pw.println();
            }
        }

        pw.close();
    }
}
