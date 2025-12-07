import java.io.*;
import java.util.*;

public class CowGymnastics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] sessions = new int[K][N + 1];

        int numConsistent = 0;

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                sessions[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // start at cow 1 and go up to cow n inclusive
        for(int i = 1; i <= N; i++){
            for(int j = i + 1; j <= N; j++){
                if(i == j){
                    continue;
                }

                int above = 0;
                int below = 0;
                for(int round = 0; round < K; round++){
                    if(index(sessions[round], i) < index(sessions[round], j)){
                        above++;
                    } else {
                        below++;
                    }
                }

                if(above == K || below == K){
                    numConsistent++;
                }
            }
        }

        pw.println(numConsistent);
        pw.close();
    }

    static int index(int[] round, int cow){
        for(int i = 0; i < round.length; i++){
            if(round[i] == cow){
                return i;
            }
        }; 
        return -1;
    }
}
