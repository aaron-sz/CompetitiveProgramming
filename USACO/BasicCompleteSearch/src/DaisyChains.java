import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class DaisyChains {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numFlowers = Integer.parseInt(st.nextToken());
        int validPhotos = 0;
        int[] flowers = new int[numFlowers];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < numFlowers; i++){
            flowers[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < numFlowers; i++){
            for(int j = i; j < numFlowers; j++){
                int currentSum = 0;
                for(int k = i; k <= j; k++){
                    currentSum += flowers[k];
                }

                int count = j - i + 1;
                if(currentSum % count != 0){
                    continue;
                }

                int average = currentSum / count;
                boolean found = false;
                for(int k = i; k <= j; k++){
                    if(flowers[k] == average){
                        found = true;
                        break;
                    }
                }

                if(found){
                    validPhotos++;
                }
            }

        }
        

        pw.println(validPhotos);
        pw.close();
    }
}
