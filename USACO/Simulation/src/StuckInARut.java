import java.io.*;
import java.util.*;

public class StuckInARut {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<int[]> eCows = new ArrayList<>();
        ArrayList<int[]> nCows = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String dir = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(dir.equals("E")){
                eCows.add(new int[] {x, y, i});
            } else {
                nCows.add(new int[] {x,y,i});
            }
        }

        nCows.sort(Comparator.comparingInt(o -> o[0]));
        eCows.sort(Comparator.comparingInt(o -> o[1]));

        int[] collisionPositions = new int[n];
        Arrays.fill(collisionPositions, -1);

        for(int[] ncow : nCows){
            for(int[] ecow : eCows){
                if(ncow[0] > ecow[0] && ncow[1] < ecow[1]){
                    int nTrav = ecow[1] - ncow[1];
                    int eTrav = ncow[0] - ecow[0];

                    // check if north cow blocks east cow
                    if(nTrav < eTrav && collisionPositions[ecow[2]] == -1){
                        // save x-cord at where cow stops
                        collisionPositions[ecow[2]] = ncow[0];
                    }

                    // check if east cow blocks north
                    if(nTrav > eTrav  && collisionPositions[ecow[2]] == -1){
                        // save y cord at where north cow stops
                        collisionPositions[ncow[2]] = ecow[1];
                        break;
                    }
                }
            }
        }

        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        for(int[] ncow: nCows){
            if(collisionPositions[ncow[2]] != -1){
                dist[ncow[2]] = collisionPositions[ncow[2]] - ncow[1];
            }
        }

        for(int[] ecow : eCows){
            if(collisionPositions[ecow[2]] != -1){
                dist[ecow[2]] = collisionPositions[ecow[2]] - ecow[0];
            }
        }

        for(int d : dist){
            System.out.println(d == -1 ? "Infinity" : d);
        }
    }
}
