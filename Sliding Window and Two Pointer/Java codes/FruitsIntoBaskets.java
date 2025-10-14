import java.util.*;

public class FruitsIntoBaskets {

    public static int maxFruits(int fruitTypes[]){
        int n = fruitTypes.length;

        HashMap<Integer, Integer> freq = new HashMap<>();

        int l = 0;
        int r = 0;

        int max = 0;

        while(r < n){
            freq.put(fruitTypes[r], freq.getOrDefault(fruitTypes[r], 0)+1);

            while(freq.size() > 2){
                freq.put(fruitTypes[l], freq.getOrDefault(fruitTypes[l], 0)-1);
                if(freq.get(fruitTypes[l]) == 0){
                    freq.remove(fruitTypes[l]);
                }
                l++;
            }

            max = Math.max(max, r-l+1);
            r++;
        }

        return max;
    }
    
    public static void main(String args[]){
        int fruitTypes[] = {3,3,3,1,2,1,1,2,3,3,4};

        System.out.println(maxFruits(fruitTypes));
    }
}
