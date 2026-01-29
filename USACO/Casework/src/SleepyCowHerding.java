import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SleepyCowHerding {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("herding.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("herding.out"));

        int[] cows = new int[3];
        cows[0] = Integer.parseInt(st.nextToken());
        cows[1] = Integer.parseInt(st.nextToken());
        cows[2] = Integer.parseInt(st.nextToken());
        Arrays.sort(cows);

        if(cows[2] == cows[0] + 2){
            pw.println(0);
        } else if (cows[1] == cows[0] + 2 || cows[2] == cows[1] + 2){
            pw.println(1);
        } else {
            pw.println(2);
        }

        pw.println(Math.max(cows[1] - cows[0], cows[2] - cows[1]) -1);
        pw.close();
    }
}
