import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jigsaw {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for(int test = 0; test < t; test++){
            st = new StringTokenizer(br.readLine());
            int days = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int happy = 0;
            int p = 0;
            for(int day = 0; day < days; day++){
                p += Integer.parseInt(st.nextToken());

                if(Math.pow((double) p, 0.5) % 1 == 0 && Math.pow((double) p, 0.5) % 2 != 0){
                    happy++;
                }

            }

            if(happy == 0){
                happy++;
            }
            System.out.println(happy);
        }
    }
}
