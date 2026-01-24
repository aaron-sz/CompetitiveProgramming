package r800;
import java.io.*;
import java.util.*;

public class ArrayColoring {

    static class Card {
        int val;
        int color;

        public Card(int val, int color){
            this.val = val;
            this.color = color;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tests = Integer.parseInt(st.nextToken());
        for(int test = 0; test < tests; test++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            boolean possible = true;

            st = new StringTokenizer(br.readLine());
            Card[] cards = new Card[n];
            for(int i = 0; i < n; i++){
                int col = 0;
                if(i % 2 == 0){
                    col = 1;
                }
                cards[i] = new Card(Integer.parseInt(st.nextToken()), col);
            }

            Arrays.sort(cards, (a,b) -> Integer.compare(a.val, b.val));
            
            for(int i = 0; i < n - 1; i++){
                if(cards[i + 1].color == cards[i].color){
                    pw.println("NO");
                    possible = false;
                    break;
                }
            }

            if(possible){
                pw.println("YES");
            }
        }
        pw.close();
    }
}
