import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CreatingStrings {
    static int n;
    static int[] characterCount = new int[26];
    static ArrayList<String> permutations = new ArrayList<>();
    static String word;
    static PrintWriter pw = new PrintWriter(System.out);
    static String currentPerm;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        word = st.nextToken();
        n = word.length();

        for(int i = 0; i < n; i++){
            characterCount[word.charAt(i) - 'a']++;
        }

        search("");
        pw.println(permutations.size());
        for(String p : permutations){
            pw.println(p);
        }
        pw.close();
    }

    static void search(String currentPerm){
        if(currentPerm.length() == n){
            permutations.add(currentPerm);
        } else {
            for(int i = 0; i < 26; i++){
                if(characterCount[i] > 0){
                    characterCount[i]--;
                    currentPerm += (char)(i + 'a'); // adding to subset
                    search(currentPerm);
                    characterCount[i]++;
                    currentPerm = currentPerm.substring(0,currentPerm.length() -1);
                }
            }
        }
    }
}
