import java.io.*;
import java.util.*;

public class GuessTheAnimal{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("guess.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));   

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numAnimals = Integer.parseInt(st.nextToken());

        HashSet<String>[] animals = new HashSet[numAnimals];

        for(int i = 0; i < numAnimals; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int attributes = Integer.parseInt(st.nextToken());

            animals[i] = new HashSet<>();

            for(int attribute = 0; attribute < attributes; attribute++){
                animals[i].add(st.nextToken());
            }

        }
        int maxCommon = 0;
        for(int animal = 0; animal < numAnimals; animal++){
            for(int animal2 = animal + 1; animal2 < numAnimals; animal2++){
                int numCommon = 0;
                for(String trait : animals[animal]){
                    for(String trait2 : animals[animal2]){
                        if(trait.equals(trait2)){
                            numCommon++;
                        }
                    }
                }

                maxCommon = Math.max(maxCommon, numCommon);
            }
        }

        pw.println(maxCommon + 1);
        pw.close();
    }
}
