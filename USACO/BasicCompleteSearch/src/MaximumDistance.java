import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;;

public class MaximumDistance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int maxDist = 0;
        int[] x = new int[n];
        int[] y = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            x[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            y[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int dx = x[i] - x[j];
                int dy = y[i] - y[j];

                int totalDist = dx * dx + dy * dy;
                maxDist = Math.max(maxDist, totalDist);
            }
        }

        pw.println(maxDist);
        pw.close();
    }
}