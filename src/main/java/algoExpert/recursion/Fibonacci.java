package algoExpert.recursion;

import java.util.HashMap;
import java.util.Map;

/*
Fibonacci - F(n) = F(n-1 ) + F(n-2)
where F(0) = 0 and F(1) = 1
0,1,1,2,3,5,8,13 ....
if n = 2 , pick first 2 elements 0 +1 = 1
*/
public class Fibonacci {
    // Not optimized as duplicates are calcuated
    // Every level calls 2 more fn()
    // O(2^n) time complexity | O(n) space as all elements are in the call stack
    public static int getNthFibUsingRecursion(int n ){
        // Base case:
        if (n== 2){
            return 1;
        }else if ( n ==1){
            return 0;
        }else {
            return getNthFibUsingRecursion(n-1) + getNthFibUsingRecursion(n-2);
        }
    }
    // Optimized O(n) time | O(n) space ( frames on call stack + hash value storage )
    public static int getNthFibUsingHash(int n ){
        Map<Integer,Integer> memoize = new HashMap<Integer,Integer>();
        memoize.put(1,0); // n=1 , value =0
        memoize.put(2,1); // n=2 , value =1
        return getNthFibUsingHash(n,memoize);

    }
    public static int getNthFibUsingHash(int n , Map<Integer,Integer> memoize){
        if (!memoize.containsKey(n)) {
            memoize.put(n, getNthFibUsingHash(n - 1, memoize) + getNthFibUsingHash(n - 2, memoize));
        }
        return memoize.get(n);
    }

    // Approach 3 - iterative - recommended
    //O(n) time | O(1) space
    public static int getNthFib(int n){
        int[] lastTwo= {0,1};
        int counter = 3;

        while ( counter <=n){
            int nextFib = lastTwo[0] + lastTwo[1];
            lastTwo[0] = lastTwo[1];
            lastTwo[1] = nextFib;
            counter++;
        }
        return n > 1 ? lastTwo[1] : 0;
    }

    public static void main(String[] args) {
        System.out.println(getNthFibUsingRecursion(6));
        System.out.println(getNthFibUsingHash(6));
        System.out.println(getNthFib(6));
    }
}
