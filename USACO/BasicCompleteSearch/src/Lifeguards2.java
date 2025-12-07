import java.io.*;
import java.util.*;

public class Lifeguards2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int maxTime = -1;
        int[] startTimes = new int[n];
        int[] endTimes = new int[n]; // initializes the start and end times for each cow
        int[] covered = new int[1000];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine()); // gets the next cow
            startTimes[i] = Integer.parseInt(st.nextToken());
            endTimes[i] = Integer.parseInt(st.nextToken()); // puts the values in
            for(int k = startTimes[i]; k < endTimes[i]; k++){
                covered[k]++;
            }
        }

        for(int cow = 0; cow < n; cow++){
            for(int t = startTimes[cow]; t < endTimes[cow]; t++){
                covered[t]--;
            }

            int cov = 0;
            for(int i = 0; i < 1000; i++){
                if(covered[i] > 0){
                    cov++;
                }
            }

            maxTime = Math.max(maxTime,cov);

            for(int t = startTimes[cow]; t < endTimes[cow]; t++){
                covered[t]++;
            }
        }

        pw.println(maxTime);
        pw.close();
    }
}
