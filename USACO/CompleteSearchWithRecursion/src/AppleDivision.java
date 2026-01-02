import java.io.*;
import java.util.*;

public class AppleDivision {
    static int numApples;
    static ArrayList<Integer> currentApples = new ArrayList<>();
    static int[] apples;
    static long totalSum;
    static long lowestDiff = Integer.MAX_VALUE; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numApples = Integer.parseInt(st.nextToken());
        apples = new int[numApples];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < numApples; i++){
            apples[i] = Integer.parseInt(st.nextToken());
            totalSum += apples[i];
        }
        search(0);

        System.out.println(lowestDiff);
    }

    static void search(int k){
        if(k == numApples){
            // do the logic
            long currentsum = 0;
            for(int weight : currentApples){
                currentsum += weight;
            }

            long otherBasket = totalSum - currentsum;
            long difference = Math.abs(otherBasket - currentsum);

            lowestDiff = Math.min(lowestDiff, difference);
        } else {
            search(k + 1);
            currentApples.add(apples[k]);
            search(k + 1);
            currentApples.remove(currentApples.size() - 1);
        }
    }
}
