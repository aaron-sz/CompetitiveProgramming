import java.io.*;
import java.util.*;

public class OutOfMemoryError {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for(int test = 0; test < t; test++){
            int n;
            int m;
            long h;

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            long[] baseNums = new long[n];
            for(int i = 0; i < n; i++){
                baseNums[i] = Long.parseLong(st.nextToken());
            }

            long[] altered = Arrays.copyOf(baseNums, baseNums.length);

            for(int opp = 0; opp < m; opp++){
                st = new StringTokenizer(br.readLine());

                int bi = Integer.parseInt(st.nextToken());
                long ci = Long.parseLong(st.nextToken());

                altered[bi - 1] += ci;

                if(altered[bi - 1] > h){
                    altered = Arrays.copyOf(baseNums, baseNums.length); 
                }
            }

            for(long val : altered){
                pw.print(val + " ");
            }

            pw.println();
        }

        pw.close();
    }
}
