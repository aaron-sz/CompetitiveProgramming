package r800;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Bit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(st.nextToken());
        int x = 0;
        for(int i = 0; i < n; i++){
            String line = br.readLine();

            if(line.contains("++")){
                x++;
            } else {
                x--;
            }
        }

        pw.println(x);
        pw.close();
    }
}
