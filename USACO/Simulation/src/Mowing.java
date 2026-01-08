import java.io.*;
import java.util.*;

public class Mowing {
    public class step {

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("mowing.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("mowing.out"));

        int n = Integer.parseInt(st.nextToken());
        int[][] lawn = new int[2001][2001];

        int t = 0;
        int x = 0;
        int y = 0;

        int lowestGrowth = 20000;
        boolean crosses = false;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String direction = st.nextToken();
            int val = Integer.parseInt(st.nextToken());

            for(int patch = 0; patch < val; patch++){
                t++;

                if(direction.equals("N")){
                    y++;
                } else if(direction.equals("E")){
                    x++;
                } else if(direction.equals("S")){
                    y--;
                } else if(direction.equals("W")){
                    x--;
                }
                if(lawn[y + 1000][x + 1000] > 0){
                    int mowedAt = lawn[y + 1000][x + 1000];
                    lowestGrowth = Math.min(lowestGrowth, t- mowedAt);
                    crosses = true;
                }
                lawn[y + 1000][x + 1000] = t;
            }

        }
        
        if(crosses){
            pw.println(lowestGrowth);
        } else {
            pw.println(-1);
        }

        pw.close();

    }
}
