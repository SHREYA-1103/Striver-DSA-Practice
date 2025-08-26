import java.util.*;

public class IntersectionSortedArrays {

    // bruteforce - O(n1 * n2), O(2n)
    public static int[] intersection_brute(int arr1[], int arr2[]){
        boolean vis[] = new boolean[arr2.length];

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<arr1.length; i++){
            int j = 0;
            while(j < arr2.length && arr2[j] <= arr1[i]){
                if(arr1[i] == arr2[j] && !vis[j]){
                    vis[j] = true;
                    list.add(arr1[i]);
                    break;
                }
                j++;
            }
        }

        int intersection[] = new int[list.size()];

        int idx = 0;

        for(int k: list){
            intersection[idx++] = k;
        }

        return intersection;
    }

    // optimal - O(n1 + n2), O(n)
    public static int[] intersection_optimal(int arr1[], int arr2[]){
        int i = 0;
        int j = 0;

        List<Integer> list = new ArrayList<>();

        while(i < arr1.length && j < arr2.length){
            if(arr1[i] == arr2[j]){
                list.add(arr1[i]);
                i++;
                j++;
            }
            else if(arr1[i] < arr2[j]){
                i++;
            }
            else if(arr2[j] < arr1[i]){
                j++;
            }
        }

        int intersection[] = new int[list.size()];

        int idx = 0;

        for(int k: list){
            intersection[idx++] = k;
        }

        return intersection;
    }
    
    public static void main(String args[]){
        int arr1[] = {1,2,5,10,10,11,13};
        int arr2[] = {2,5,8,10,10};

        int intersection[] = intersection_brute(arr1, arr2);

        for(int i=0; i<intersection.length; i++){
            System.out.print(intersection[i] + " ");
        }
    }
}
