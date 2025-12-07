import java.io.*;
import java.util.*;

public class BovineGenomics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numCows = Integer.parseInt(st.nextToken());
        int genomeLength = Integer.parseInt(st.nextToken());
        int traitPairs = 0;

        int[][] spotty = new int[numCows][genomeLength];
        int[][] plain = new int[numCows][genomeLength];
        boolean[][] same = new boolean[numCows][genomeLength];

        for(int i = 0; i < numCows; i++){
            String sequence = br.readLine();
            for(int j = 0; j < genomeLength; j++){
                spotty[i][j] = sequence.charAt(j);
            }
        }

        for(int i = 0; i < numCows; i++){
            String sequence = br.readLine();
            for(int j = 0; j < genomeLength; j++){
                plain[i][j] = sequence.charAt(j);
            }
        }

        // check each cow thing
        for(int spottedCow = 0; spottedCow < numCows; spottedCow++){
            int[] currentCow = spotty[spottedCow];
            for(int genome = 0; genome < genomeLength; genome++){
                int g = currentCow[genome];

                for(int plainCow = 0; plainCow < numCows; plainCow++){
                    if(plain[plainCow][genome] == g){
                        same[plainCow][genome] = true;
                    }
                }
            }
        }

        for(int i = 0; i < genomeLength; i++){
            boolean trait = true;
            for(int j = 0; j < numCows; j++){
                if(same[j][i] == true){
                    trait = false;
                    break;
                }
            }

            if(trait){
                traitPairs++;
            }
        }

        pw.println(traitPairs);
        pw.close();
    }
}
