import java.io.*;
import java.util.*;

public class Lifeguards {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] cows = new int[n][2];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }

        int maxTime = 0;
        for(int cow = 0; cow < n; cow++){
            boolean[] covered = new boolean[1000];
            for(int c = 0; c < n; c++){
                if(cow == c){
                    continue;
                }
                int start = cows[c][0];
                int end = cows[c][1];
                for(int t = start; t < end; t++){
                    covered[t - 1] = true;
                }
            }

            int time = 0;
            for(int i = 0; i < 1000; i++){
                if(covered[i]){
                    time++;
                }
            }
            maxTime = Math.max(maxTime, time);
        }

        pw.println(maxTime);
        pw.close();
    }
}
