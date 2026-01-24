package r800;
import java.util.*;

public class TwoElevators {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();
        for(int i = 0; i < t; i++){
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();

            int timeForA = a - 1;
            int bToC = Math.abs(b - c);
            int cToA = c - 1;

            if(timeForA < bToC + cToA){
                System.out.println(1);
            } else if (timeForA > bToC + cToA){
                System.out.println(2);
            } else {
                System.out.println(3);
            }
        }
    }
}
