package r800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Template {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tests = Integer.parseInt(st.nextToken());
        for(int t = 0; t < tests; t++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            String a = br.readLine();
            String b = br.readLine();
            String c = br.readLine();

            int numSame = 0;
            for(int i = 0; i < n; i++){
                if(a.charAt(i) == c.charAt(i) || b.charAt(i) == c.charAt(i)){
                    numSame++;
                }
            }

            if(numSame == n){
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
