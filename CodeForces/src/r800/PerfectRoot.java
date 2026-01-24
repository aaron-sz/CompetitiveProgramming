package r800;
import java.io.*;
import java.util.StringTokenizer;

public class PerfectRoot {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        int tests = Integer.parseInt(st.nextToken());

        for(int t = 0; t < tests; t++){
            st = new StringTokenizer(br.readLine());

            int numRoots = Integer.parseInt(st.nextToken());

            for(int root = 1; root <= numRoots; root++){
                pw.print(root + " ");
            }

            pw.println();
        }

        pw.close();
    }   
}
