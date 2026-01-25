package r800;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CardTrick {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(st.nextToken());
        for(int q = 0; q < t; q++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] nums = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            long sumB = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++){
                sumB += Integer.parseInt(st.nextToken());
            }   

            long idx = sumB % (long) n;
            pw.println((nums[(int) idx]));
        }

        pw.close();
    }
}
