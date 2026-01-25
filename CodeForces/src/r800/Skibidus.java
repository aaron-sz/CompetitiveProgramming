package r800;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Skibidus {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for(int i = 0; i < t; i++){
            String str = br.readLine();
            boolean canShorten = false;
            for(int s = str.length() - 1; s > 0; s--){
                char c = str.charAt(s);
                char n = str.charAt(s - 1);

                if(c == n){
                    System.out.println(1);
                    canShorten = true;
                    break;
                }
            }

            if(!canShorten){
                System.out.println(str.length());
            }
        }
    }
}
