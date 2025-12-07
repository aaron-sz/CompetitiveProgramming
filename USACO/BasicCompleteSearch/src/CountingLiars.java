import java.io.*;
import java.util.*;

public class CountingLiars {
    static class Cow implements Comparable<Cow> {
        int val;
        char type;

        public Cow(int val, char type){
            this.val = val;
            this.type = type;
        }

        @Override
        public int compareTo(Cow c) {
            if(val != c.val) { return val - c.val; }
            return type - c.type;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Cow[] cows = new Cow[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            char type = st.nextToken().charAt(0);
            int val = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(val,type);
        }

        Arrays.sort(cows);
        int liars = 0;
        int minLiars = 0;
        for(int i = 1; i < N; i++){
            if(cows[i].type == 'G'){
                liars++;
            }
        }

        minLiars = liars;

        for(int i = 1; i < N; i++){
            if(cows[i-1].type == 'L'){
                liars += 1;
            }

            if(cows[i].type == 'G'){
                liars -= 1;
            }

            minLiars = Math.min(minLiars,liars);
        }
        

        pw.println(minLiars);
        pw.close();
    }
}
