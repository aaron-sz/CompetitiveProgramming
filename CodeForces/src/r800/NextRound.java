package r800;
import java.util.Scanner;

public class NextRound {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int k = input.nextInt();
        k--;

        int[] scores = new int[n];
        for(int i = 0; i < n; i++){
            scores[i] = input.nextInt();
        }

        int cutoff = scores[k];
        int promoted = 0;
        for(int i = 0; i < n; i++){
            if(scores[i] >= cutoff && scores[i] > 0){
                promoted++;
            }
        }

        System.out.println(promoted);
    }
}
