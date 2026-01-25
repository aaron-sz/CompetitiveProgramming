package r800;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Maxmina {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tests = Integer.parseInt(st.nextToken());
        for(int t = 0; t < tests; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            boolean hasOne = false;
            for(int i = 0; i < n; i++){
                if(Integer.parseInt(st.nextToken()) == 1){
                    hasOne = true;
                    System.out.println("YES");
                    break;
                }
            }

            if(!hasOne){
                System.out.println("NO");
            }
        }
    }
}
