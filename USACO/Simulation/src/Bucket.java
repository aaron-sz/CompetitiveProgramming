import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bucket {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("blist.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numCows = Integer.parseInt(st.nextToken());
        int[] startTimes = new int[numCows];
        int[] endTimes = new int[numCows];
        int[] bucketCounts = new int[numCows];

        for(int i = 0; i < numCows; i++){
            st = new StringTokenizer(br.readLine());
            startTimes[i] = Integer.parseInt(st.nextToken());
            endTimes[i] = Integer.parseInt(st.nextToken());
            bucketCounts[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for(int i = 1; i < 1000; i++){
            int currentBuckets = 0;
            for(int cow = 0; cow < numCows; cow++){
                if(startTimes[cow] <= i && i <= endTimes[cow]) {
                    currentBuckets += bucketCounts[cow];
                }
            }
            max = Math.max(currentBuckets, max);
        }

        pw.println(max);
        pw.close();
    }
}
