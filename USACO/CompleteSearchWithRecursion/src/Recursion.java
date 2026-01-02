import java.util.*;

public class Recursion {
    static int n = 3;
    static ArrayList<Integer> subset = new ArrayList<>();
    static ArrayList<Integer> permutation = new ArrayList<>();
    static boolean[] chosen = new boolean[n];
    public static void main(String[] args) {
        search2();
    }

    static void search(int k){
        if(k == n){
            // process
            System.out.println(subset);
        } else {
            search(k + 1);
            subset.add(k);
            search(k + 1);
            subset.remove(subset.size() - 1);
        }
    }

    static void search2(){
        if(permutation.size() == n){
            // process
            System.out.println(permutation);
        } else {
            for(int i = 0; i < n; i++){
                if(!chosen[i]){
                    chosen[i] = true;
                    System.out.println("Adding: " + i + " to: " + permutation);
                    permutation.add(i);
                    search2();
                    chosen[i] = false;
                    System.out.println("Removing: " + permutation.get(permutation.size()-1));
                    permutation.remove(permutation.size() - 1);
                }
            }
        }
    }
}
