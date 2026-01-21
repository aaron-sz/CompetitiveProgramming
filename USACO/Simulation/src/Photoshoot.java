import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Photoshoot {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());

        int[][] cows = new int[n][n];

        // top left corners
        int[][] pics = new int[n][n];

        int maxSum = 0;
        
        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            r--;
            c--;

            // calc what pics the new val is in.
            int colStart = Math.max(c - k + 1, 0); // make sure we not out of bounds
            int colEnd = Math.min(c, n - k);

            int rowStart = Math.max(0, r - k + 1);
            int rowEnd = Math.min(r, n - k );

            int difference = v - cows[r][c];

            cows[r][c] = v;

            for(int col = colStart; col <= colEnd; col++){ 
                for(int row = rowStart; row <= rowEnd; row++){
                    pics[row][col] += difference;
                    maxSum = Math.max(maxSum, pics[row][col]);
                }
            }

            pw.println(maxSum);
        }

        pw.close();
    }
}
