package algoExpert.searching;

/*
Input to method - sorted int[] arr and targetSum
Return index if matches , else -1
 */
public class BinarySearch {

    public static int binarySearch( int arr[], int target){
        // O(log n ) time | 0 (log n ) space
        // Uses O(log n ) space as its recursive ( frames on call stack usage )
        //return binarySearch(arr,target, 0, arr.length-1);

        // Optimized ( recommended - Iterative Solution )
        // O(log n ) time | 0 (1) space
        return binarySearchIterative(arr,target, 0, arr.length-1);
    }
    public static int binarySearchIterative(int arr[], int target, int left , int right){
        while ( left <= right){
            int middle = ( left + right )/2;
            int potentialMatch = arr[middle];
            if ( target == potentialMatch){
                return middle;
            }else if ( target < potentialMatch){
                right = middle -1;
            }else {
                left = left + 1;
            }
        }
        return -1;
    }
    public static int binarySearch(int arr[], int target, int left , int right){
        // Note for binary search the arr has to be sorted
        if (left > right){
            System.out.println("Exiting as left index > right index" + left + right);
            return -1;
        }
        int middle = (left + right)/2;
        System.out.println("Middle index" + middle);
        System.out.println("Middle element" + arr[middle]);

        int potentialMatch = arr[middle];
        if ( target == potentialMatch){
            System.out.println("Target found at index"+ middle );
            return middle;
        }else if ( target < potentialMatch){
            return binarySearch(arr,target,left, middle -1);
        }else {
            return binarySearch(arr,target,middle+1, right);
        }
    }
    public static void main(String[] args) {

        int arr[]= {10,20,30,40,50,60};
        int target = 30;
        System.out.println(binarySearch(arr, target));
    }
}
