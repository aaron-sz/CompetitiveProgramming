package r800;
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
            long[] baseNums = new long[n]; for(int i = 0; i < n; i++){ baseNums[i] = Long.parseLong(st.nextToken());}
            long[] altered = Arrays.copyOf(baseNums, baseNums.length);
            long[] last_element_update = new long[n]; for(int i = 0; i < last_element_update.length; i++){ last_element_update[i] = -1; }

            int lastReset = -1;
            int resetCount = 0;
            for(int opp = 0; opp < m; opp++){
                st = new StringTokenizer(br.readLine());

                int bi = Integer.parseInt(st.nextToken());
                long ci = Long.parseLong(st.nextToken());

                bi--;

                if(last_element_update[bi] < lastReset){
                    altered[bi] = baseNums[bi];
                }

                altered[bi] += ci;

                if(altered[bi] > h){
                    lastReset = opp;
                    resetCount++;
                    altered[bi] = baseNums[bi];
                }

                last_element_update[bi] = opp;
            }

            for(int i = 0; i < n; i++){
                if(last_element_update[i] < lastReset){
                    altered[i] = baseNums[i];
                }
                pw.print(altered[i] + " ");
            }

            pw.println();
        }

        pw.close();
    }
}
