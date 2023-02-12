package algoExpert.arrays;

import java.util.Arrays;
import java.util.HashSet;

/*
- Input - Non empty array of int
- Input - target Sum
- Find if 2 num can sum upto targetSum return them in array, else return empty array
- Note : Cant add single int to itself
O(n) time | O(n ) space
*/
public class TwoNumberSum {
    public static int[] twoNumberSum(int[] array, int targetSum){
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for ( int i: array){
            int potentialMatch = targetSum -i;
            if (hashSet.contains(potentialMatch)){
                return new int[] {i, potentialMatch};
            }
            hashSet.add(i);
        }
        return new int[0];
    }
    public static void main(String[] args) {
        int[] arr = {3,5,-4,8,11,1,-1,6};
        System.out.println(Arrays.toString(twoNumberSum(arr, 10)));
    }
}
