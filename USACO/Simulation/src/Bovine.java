import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bovine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] shuffle =  new int[n + 1];
        int[] finalOrder = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int to = Integer.parseInt(st.nextToken());
            shuffle[i] = to;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int to = Integer.parseInt(st.nextToken());
            finalOrder[i] = to;
        }

        int[] newOrder = new int[n + 1];
        for(int round = 0; round < 3; round++){
            for(int i = 1; i <= n; i++){
                newOrder[i] = finalOrder[shuffle[i]];
            }
            finalOrder = newOrder.clone();
        }

        for(int i = 1; i <= n; i++){
            pw.println(finalOrder[i]);
        }
        pw.close();
    }
}