// -------------------------------- Ques --------------------------------
// Given two arrays with details aboutn items, val[i] denoting the value of the ith item and wt[i] denoting the weight of the ith item along with the capacity of a bag. Find the maximum valued items that can be kept in the bag such the combined weight of the selected items is less than or equal to the given capacity. Assume that the items can also be selected partially.
// ----------------------------------------------------------------------


import java.util.*;

public class FractionalKnapsack {
    
    public static class Item implements Comparable<Item>{
       int wt;
       int val;
       double ratio;
       
       public Item(int w, int v){
           this.wt = w;
           this.val = v;
           this.ratio = (double)val/wt;
       }
       
       @Override
       public int compareTo(Item i2){
           return Double.compare(i2.ratio , this.ratio);
       }
    }

    // optimal - O(n log n), O(n)
    public static double maxValue(int[] val, int[] wt, int capacity) {
        PriorityQueue<Item> pq = new PriorityQueue<>();
        
        for(int i=0; i<wt.length; i++){
            pq.add(new Item(wt[i], val[i]));
        }
        
        double profit = 0;
        
        while(capacity > 0 && !pq.isEmpty()){
            Item i = pq.remove();
            
            if(i.wt <= capacity){
                capacity -= i.wt;
                profit += i.val;
            }
            else{
                profit += capacity*i.ratio;
                capacity = 0;
            }
        }
        
        return profit;
    }

    public static void main(String args[]){
        int val[] = {100, 60, 100, 200};
        int wt[] = {20, 10, 50, 50};
        int capacity = 90;

        System.out.println(maxValue(val, wt, capacity));
    }
}