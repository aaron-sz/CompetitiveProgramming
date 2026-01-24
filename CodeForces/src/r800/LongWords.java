package r800;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LongWords {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        int tests = Integer.parseInt(st.nextToken());
        for(int t = 0; t < tests; t++){
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();

            if(word.length() > 10){
                pw.println(word.substring(0,1) + (word.length() - 2) + word.substring(word.length() - 1, word.length()));
            } else {
                pw.println(word);
            }
        }

        pw.close();
    }
}
