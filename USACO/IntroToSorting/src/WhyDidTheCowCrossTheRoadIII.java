import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WhyDidTheCowCrossTheRoadIII {
    public static class Cow{
        int arrival;
        int questioningTime;

        public Cow(int arrival, int questioningTime){
            this.arrival = arrival;
            this.questioningTime = questioningTime;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowqueue.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("cowqueue.out"));

        int n = Integer.parseInt(st.nextToken());
        Cow[] cows = new Cow[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int arrival = Integer.parseInt(st.nextToken());
            int questioningTime = Integer.parseInt(st.nextToken());

            Cow c = new Cow(arrival, questioningTime);
            cows[i] = c;
        }

        Arrays.sort(cows, (a, b) -> Integer.compare(a.arrival, b.arrival));

        int currentTime = 0;

        for(Cow c : cows){
            currentTime  = Math.max(currentTime, c.arrival) + c.questioningTime;
        }

        pw.println(currentTime);
        pw.close();
    }
}