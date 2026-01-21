import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.AnnotatedArrayType;
import java.util.Currency;
import java.util.StringTokenizer;

public class ChipExchange {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        int tests = Integer.parseInt(st.nextToken());

        for(int t = 0; t < tests; t++){
            st = new StringTokenizer(br.readLine());
            long A = Integer.parseInt(st.nextToken());
            long B = Integer.parseInt(st.nextToken());
            long cA = Integer.parseInt(st.nextToken());
            long cB = Integer.parseInt(st.nextToken());
            long FA = Integer.parseInt(st.nextToken());

            // Exchange what we have
            long times = B / cB;
            B -= times * cB;
            A += times * cA;
            
            if(A >= FA){
                pw.println(0);
                continue;
            }

            FA -= A;

            long wasteB = cB - 1 - B; // fill up b to worst scenario: 6b -> 9a : 5b. 

            long answer1 = wasteB + FA; // Fill with all A.
            
            long wasteA = (FA - 1) % cA; 
            times = Math.max(1, (FA + cA - 1) / cA); // Ceiling: FA / cA
            long answer2 = wasteA + times * cB - B;

            pw.println(Math.max(answer1, answer2));
        }

        pw.close();
    }
}
