import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ChessboardAndQueens {
    static int n = 8;
    static int count = 0;
    static boolean[] columns = new boolean[n];
    static boolean[] diag1 = new boolean[2 *n];
    static boolean[] diag2 = new boolean[2 * n];
    static boolean[][] placementArr = new boolean[n][n];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int row = 0; row < n; row++){
            st = new StringTokenizer(br.readLine());
            String r = st.nextToken();

            for(int col = 0; col < n; col++){
                if(r.charAt(col) == '*'){
                    placementArr[row][col] = true;
                }
            }
        }

        search(0);
        System.out.println(count);
    }
    
    static void search(int row){
        if(row == n){
            count++;
        } else {
            for(int col = 0; col < n; col++){
                if(columns[col] || diag1[col + row] || diag2[col - row + n - 1] || placementArr[row][col]){
                    continue; // skip this column / diagonal/ its got real estate
                }

                // mark this spot as taken
                columns[col] = true;
                diag1[col + row]  = true;
                diag2[col - row + n - 1] = true;

                // recurse
                search(row + 1);

                // backtrack
                columns[col] = false;
                diag1[col + row]  = false;
                diag2[col - row + n - 1] = false;
            }
        }
    }
}
