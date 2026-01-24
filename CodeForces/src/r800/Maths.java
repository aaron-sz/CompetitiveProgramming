package r800;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Maths {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        ArrayList<Integer> nums = new ArrayList<>();

        String line = br.readLine();

        for(int i = 0; i < line.length(); i++){
            if(!line.substring(i, i+1).contains("+")){
                nums.add(Integer.parseInt(line.substring(i, i+1)));
            }
        }

        Collections.sort(nums);

        for(int i = 0; i < nums.size(); i++){
            if(i == (nums.size() - 1)){
                pw.println(nums.get(i));
            } else {
                pw.print(nums.get(i) + "+");
            }
        }
        pw.close();
    }
}
