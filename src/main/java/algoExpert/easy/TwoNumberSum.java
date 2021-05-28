package algoExpert.easy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class TwoNumberSum {
    /*
        Write a func with takes a non empty array of distinct integers and int representing a
        target sum.
        if any 2 numbers in the array sum up to the target sum , return them in an array in any
        order.
        if no numbers sum up to target , return empty array.
        Cant add number to itself.
        Assume there will be at most one of number summing to target.
    */

    /*
        Three solution to the problems:
        1) Brute force - 0 ( n^2 )
            two nested for loops and check if the sum of any two elements in the array is equal to the given target.
        2) Hash Map - most efficient 0 (n)
            Init hash map.
            Iterate over element , if ( target - element ) is present in hash map , return
            current target + hash Map element
            else save the element in the hash map
         3) Sliding window 0 ( n log n)
            Sort array
            left point to head , right pointer to tail
            while ( left < right )
                check left + right = value
                 if target == value  return
                else if ( target is greater than value - move the left pointer and repeat.
                else ( if target is smaller than value - move the right pointer and repeat
     */

    public static int[] twoNumberSumBruteForce( int[] array , int targetSum ){
        if ( array.length == 0 ){
            System.out.println("Array is empty");
            return array;
        }
        // Since its primitive int , it cannot be null by default the value = 0
        for ( int i = 0 ; i < array.length; i ++ ){
            for ( int j = i + 1; j < array.length; j++){
                if ( array[i] + array[j] == targetSum){
                    return new int[] { array[i], array[j]};
                }
            }
        }
        return new int[] {};
    }

    public static int[] twoNumberSum( int[] array , int targetSum ){
        if ( array.length == 0 ){
            System.out.println("Array is empty");
            return array;
        }
        HashSet<Integer> map = new HashSet<>();
        for ( int i = 0 ; i < array.length ; i ++){
            int diff = targetSum - array[i];
            if ( map.contains(diff)){
                return new int[]{ diff, array[i]};
            }else{
                map.add(array[i]);
            }
        }
        return new int[] {};
    }

    public static int[] twoNumberSumSlidingWindow( int[] array , int targetSum ){
        if ( array.length == 0 ){
            System.out.println("Array is empty");
            return array;
        }
        //Sort the array - n log n
        Arrays.sort(array);

        // Keep one pointer to the left ( first element) and other to the right  ( last element )
        int left = 0;
        int right = array.length - 1;

        while ( left < right){
            if ( array[left] + array[right] == targetSum ){
                return new int[] {array[left], array[right]};
            } else if ( array[left] + array[right]  > targetSum ){
                right --;
            } else {
                left ++;
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the array length");
        int length = scan.nextInt();
        int[] arr = new int[length];
        for ( int i = 0 ; i < length; i++){
            System.out.println("Enter the numbers");
            arr[i] = scan.nextInt();
        }

        System.out.println("Enter the target sum");
        int target = scan.nextInt();
        scan.close();

        /*int[] result = twoNumberSumBruteForce(arr, target);
        if ( result.length == 2) {
            System.out.println("Solution" + result[0] + ":" + result[1]);
        }else{
            System.out.println("No solution found");
        }*/

        /*int[] result2 = twoNumberSumSlidingWindow(arr, target);
        if ( result2.length == 2) {
            System.out.println("Solution" + result2[0] + ":" + result2[1]);
        }else{
            System.out.println("No solution found");
        }*/


        // Most efficient way
        int[] result3 = twoNumberSum(arr, target);
        if ( result3.length == 2) {
            System.out.println("Solution" + result3[0] + ":" + result3[1]);
        }else{
            System.out.println("No solution found");
        }
    }
}
