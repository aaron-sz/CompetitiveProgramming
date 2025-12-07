import java.io.*;
import java.util.StringTokenizer;

public class MilkPails {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("pails.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int bucket1 = Integer.parseInt(st.nextToken());
        int bucket2 = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(st.nextToken());

        int closest = 0;
        for(int first = 0; first <= order; first++){
            if(bucket1 * first > order){
                break;
            } else {
                int b1 = bucket1 * first;
                for(int second = 0; second <= order; second++){
                    if((bucket2 * second) + b1 > order){
                        break;
                    } else {
                        closest = Math.max(closest, (bucket2 * second) + b1);
                    }
                }
            }
        }

        
        pw.println(closest);
        pw.close();
    }
}
