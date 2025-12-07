import java.io.*;
import java.util.StringTokenizer;

public class Blocks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] lettersArray = new int[26];

        for(int board = 0; board < n; board++){
            st = new StringTokenizer(br.readLine());
            String front = st.nextToken();
            String back = st.nextToken();

            int[] f1 = getFrequency(front);
            int[] f2 = getFrequency(back);

            for(int i = 0; i < 26; i++){
                int max = Math.max(f1[i], f2[i]);
                lettersArray[i] += max;
            }

        }
        for(int i = 0; i < 26; i++){
            pw.println(lettersArray[i]);
        }

        pw.close();
    }

    public static int[] getFrequency(String s){
        int[] blocksNeeded = new int[26];
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            blocksNeeded[index]++;
        }

        return blocksNeeded;
    }
}
