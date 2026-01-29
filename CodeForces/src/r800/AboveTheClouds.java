import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AboveTheClouds {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int tests = Integer.parseInt(br.readLine());
        for(int t = 0; t < tests; t++){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();

            boolean possible = false;

            int[] chars = new int[26];
            for(int i = 0; i < n; i++){
                chars[s.charAt(i) - 'a']++;
            }

            for(int i = 0; i < 26; i++){
                if(chars[i] >= 3){
                    possible = true;
                }

                if(chars[i] == 2 && (s.charAt(0) - 'a' != i || s.charAt(s.length() - 1) - 'a' != i)){
                    possible = true;
                }
            }

            if(possible){
                pw.println("Yes");
            } else {
                pw.println("No");
            }
        }
        
        pw.close();

    }
}
