import java.util.*;

public class UnionSortedArrays {
    
    // bruteforce - O(n1 log n1 + n1 log n2 + n1 + n2), O(n1 + n2)
    public static int[] union_brute(int arr1[], int arr2[]){
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }

        for(int i=0; i<arr2.length; i++){
            set.add(arr2[i]);
        }

        int union[] = new int[set.size()];

        int idx = 0;
        
        for(int i: set){
            union[idx++] = i;
        }

        return union;
    }

    // optimal - O(n1 + n2), O(n1 + n2)
    public static int[] union_optimal(int arr1[], int arr2[]){
        int i = 0;
        int j = 0;

        List<Integer> list = new ArrayList<>();
        int prev = -1;

        while(i < arr1.length && j < arr2.length){
            if(arr1[i] <= arr2[j] && arr1[i] != prev){
                list.add(arr1[i]);
                prev = arr1[i];
                i++;
            }
            else if(arr1[i] > arr2[j] && arr2[j] != prev){
                list.add(arr2[j]);
                prev = arr2[j];
                j++;
            }
            else{
                i++;
                j++;
            }
        }

        while(i < arr1.length){
            if(arr1[i] != prev){
                list.add(arr1[i]);
                prev = arr1[i];
            }
            i++;
        }

        while(j < arr2.length){
            if(arr2[j] != prev){
                list.add(arr2[j]);
                prev = arr2[j];
            }
            j++;
        }

        int union[] = new int[list.size()];

        for(int k=0; k<list.size(); k++){
            union[k] = list.get(k);
        }

        return union;
    }

    public static void main(String args[]){
        int arr1[] = {1,2,5,7};
        int arr2[] = {2,5,8,10};

        int union[] = union_brute(arr1, arr2);

        for(int i=0; i<union.length; i++){
            System.out.print(union[i] + " ");
        }
    }
}
