public class KthElementOfTwoSortedArrays {
    
    // optimal - O(log(m+n)), O(1)
    public static int findKthElement(int arr1[], int arr2[], int k){
        int m = arr1.length;
        int n = arr2.length;

        if(m > n){ // we want arr1 to be of smaller length
            return findKthElement(arr2, arr1, k);
        }

        // binary search on number of elements to be chosen from arr1
        int low = Math.max(0, k-n);
        int high = Math.min(k, m);

        int left = k; // no. of elements on left of median - equal in case of even and more in case of odd

        while(low <= high){
            int mid1 = low + (high - low)/2; // no. of elements from arr1
            int mid2 = left - mid1; // no. of elements from arr2
            
            int l1 = Integer.MIN_VALUE; // right most element from arr1 in left subarray
            int l2 = Integer.MIN_VALUE;// left most element from arr1 in right subarray

            int r1 = Integer.MAX_VALUE; // right most element from arr1 in left subarray
            int r2 = Integer.MAX_VALUE; // left most element from arr2 in right subarray

            if(mid1 < m){
                r1 = arr1[mid1];
            }

            if(mid2 < n){
                r2 = arr2[mid2];
            }

            if(mid1 > 0){
                l1 = arr1[mid1-1];
            }

            if(mid2 > 0){
                l2 = arr2[mid2-1];
            }

            if(l1 <= r2 && l2 <= r1){
                return (m+n) %2 == 0 ? (Math.max(l1, l2) + Math.min(r1, r2)) / 2 : Math.max(l1, l2);
            }

            else if(l1 > r2){
                high = mid1-1;
            }

            else{
                low = mid1+1;
            }
        }

        return -1;
    }
    
    public static void main(String args[]){
        int arr1[] = {1,3,4,7,10,12};
        int arr2[] = {1,3,5};
        int k = 3;

        System.out.println(findKthElement(arr1, arr2, k));
    }
}
