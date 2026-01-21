import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class CherryBomb {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        int te = Integer.parseInt(st.nextToken());

        test:
        for(int t = 0; t < te; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            int[] b = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                a[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                b[j] = Integer.parseInt(st.nextToken());
            }

            int s = -1;

            for(int i = 0; i < n; i++){
                if(b[i] != -1){
                    if(s == -1){
                        s = a[i] + b[i];
                    } else {
                        if(s != a[i] + b[i]){
                            pw.println(0);
                            continue test;
                        }
                    }
                }
            }

            if(s == -1){
                Arrays.sort(a);
                int diff = a[n-1] - a[0];
                pw.println(k - diff + 1);
                continue test;
            }

            for(int i = 0; i < n; i++){
                if(a[i] > s || s - a[i] > k){
                    pw.println(0);
                    continue test;
                }
            }

            pw.println(1);
        }

        pw.close();
    }
}
