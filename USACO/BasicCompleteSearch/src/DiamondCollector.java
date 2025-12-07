import java.io.*;
import java.util.*;

public class DiamondCollector {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int maxShowcase = 0;

        ArrayList<Integer> arr = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }

        

        for(int d1 : arr){
            int fit = 0;
            for(int d2 : arr){
                if(d1 <= d2 && d2 <= d1 + k){
                    fit++;
                }
            }

            maxShowcase = Math.max(maxShowcase, fit);
        }
        
        pw.println(maxShowcase);
        pw.close();
    }
}
