import java.util.*;

public class HandsOfStraights {

    public static boolean canArrangeHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int card : hand) {
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        }

        while (!freq.isEmpty()) {
            int start = freq.firstKey();

            for (int i = 0; i < groupSize; i++) {
                int card = start + i;
                if (!freq.containsKey(card)) return false;

                freq.put(card, freq.get(card) - 1);
                if (freq.get(card) == 0) {
                    freq.remove(card);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] hand1 = {1,2,3,6,2,3,4,7,8};
        int groupSize1 = 3;
        System.out.println(canArrangeHand(hand1, groupSize1));

        int[] hand2 = {1,2,3,4,5};
        int groupSize2 = 4;
        System.out.println(canArrangeHand(hand2, groupSize2));
    }
}
