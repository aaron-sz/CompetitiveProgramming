import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Circle {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));

        int n = Integer.parseInt(br.readLine());

        int[] rooms = new int[n];
        int numCows = 0;

        for(int i = 0; i <  n; i++){ rooms[i] = Integer.parseInt(br.readLine()); numCows += rooms[i];}

        int minDistance = Integer.MAX_VALUE;
        for(int startingRoom = 0; startingRoom < n; startingRoom++){
            int currentCows = numCows;
            int distance = 0;
            for(int room = startingRoom; room < startingRoom + n; room++){
                int currentRoom = rooms[room % n];
                currentCows -= currentRoom;
                distance += currentCows;
            }
            minDistance = Math.min(minDistance, distance);
        }

        pw.println(minDistance);
        pw.close();
    }
}
