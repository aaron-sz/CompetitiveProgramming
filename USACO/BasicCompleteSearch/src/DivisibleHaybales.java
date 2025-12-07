import java.io.*;
import java.util.StringTokenizer;

public class DivisibleHaybales {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int goodGroups = 0;
        int[] haybales = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){ haybales[i] = Integer.parseInt(st.nextToken()); };

        for(int i = 0; i < N; i++){
            for(int j = i; j < N; j++){
                int sum = 0;

                for(int k = i; k <= j; k++){
                    sum += haybales[k];
                }

                if(sum % M == 0){
                    goodGroups++;
                }

                pw.println("Group: ( " + i + ", " + j + "): " + sum);
            }
        }

        pw.println(goodGroups);
        pw.close();
    }
}
