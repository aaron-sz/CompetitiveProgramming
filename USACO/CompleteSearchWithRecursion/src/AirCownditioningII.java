import java.io.*;
import java.util.*;

public class AirCownditioningII {
    static int n;
    static int m;
    static int currentPrice = 0;
    static int bestPrice = Integer.MAX_VALUE;
    static int[] stables = new int[100];
    static ArrayList<ArrayList> offers = new ArrayList<>();
    static ArrayList<ArrayList> appliedOffers = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int demand = Integer.parseInt(st.nextToken());

            for(int j = start - 1; j < end; j++){
                stables[j] = demand;
            }
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int help = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            ArrayList<Integer> offer = new ArrayList<>();
            offer.add(start);
            offer.add(end);
            offer.add(help);
            offer.add(price);

            offers.add(offer);
            // System.out.println(offer);
        }  

        search(0);
        System.out.println(bestPrice);
    }

    static void search(int k){
        if(k == m){
            // apply the offers
            int totalPrice = 0;
            int[] stables2 = Arrays.copyOf(stables,100);

            for(ArrayList<Integer> offer : appliedOffers){
                int start = offer.get(0);
                int end = offer.get(1);
                int help = offer.get(2);
                int price = offer.get(3);

                for(int i = start - 1; i < end; i++){
                    stables2[i] -= help;
                }

                totalPrice = totalPrice + price;
            }

            // check if we have enough coverage
            boolean good = true;
            for(int i = 0; i < stables2.length; i++){
                if(stables2[i] > 0){
                    good = false;
                    break;
                }
            }

            if(good){
                bestPrice = Math.min(bestPrice, totalPrice);
            }


        } else {
            search(k + 1);
            appliedOffers.add(offers.get(k));
            search(k + 1);
            appliedOffers.remove(appliedOffers.size() - 1);
        }
    }
}
