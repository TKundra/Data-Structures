package Arrays;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class AllQuestions {

    // sort array using: Selection, Insertion, Bubble, Merge, Quick, Count, Heap sort, etc

    // fibonacci series i.e 0 1 1 2 3 5 8 13 ...
    static void fibonacci(){
        int a=0, b=1, c, i, count=10;
        System.out.print(a + " " + b + " ");
        for (i=2; i<count; i++){
            c = a+b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    // prime number 2,3,5,7,11,13,17
    static void primeNumber(){
        int i=0, num=0;
        StringBuilder prime = new StringBuilder();
        for (i=1; i<=20; i++){
            int counter = 0;
            for (num=i; num>=1; num--){
                if (i%num == 0){
                    counter++;
                }
            }
            if (counter == 2){
                prime.append(i).append(" ");
            }
        }
        System.out.println(prime);
    }

    // int palindrome i.e 1234 = 4321
    static void intPalindrome(){
        int n=1234, r, rev=0, temp=n;
        while (n!=0){
            r = n%10;
            rev = rev*10 + r;
            n /= 10;
        }
        if (temp == rev)
            System.out.println("palindrome");
        else
            System.out.println("not a palindrome");
    }

    // armstrong number , 1^3 + 5^3 + 3^3 = 153
    static void armstrongNumber(){
        int n=153, sum=0, r, temp=n;
        while (n!=0){
            r = n%10;
            sum += (r*r*r);
            n/=10;
        }
        if (temp == sum)
            System.out.println("armstrong number");
        else
            System.out.println("not an armstrong number");
    }

    // factorial 5! = 5x4x3x2x1 = 120
    static int factorial(int n){
        if (n == 0)
            return 1;
        return n*factorial(n-1);
    }




    // ------------------------------------------------------------------------------

    // check if key present in every segment of array
    static boolean keyPresentInEverySegment(){
        int[] array = {2,5,2, 4,9,3, 1,7,3, 11,12,3};
        int i, k=3, key=3, N= array.length;
        boolean b = false;
        for (i=0; i<N; i+=k){
            for (int j=0; j<k; j++){
                if (i+j<N && array[i+j]==key)
                    break;
                if (i+j>=N)
                    return false;
            }
        }
        if (i>=N)
            return true;
        else
            return false;
    }

    // reverse array
    static void reverseArray(){
        int[] array = {4,5,7,3,2};
        System.out.println(Arrays.toString(array));
        int temp, start=0, end=array.length-1;
        while (start < end){
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        System.out.println(Arrays.toString(array));
    }

    // find kth smallest elements
    static void kthSmallest(){
        int[] array = {4,5,2,9};
        int k=2;
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("smallest: " + array[k-1]);
    }

    // find frequency of number in an array
    static void freqOfNumberInArray(){
        int[] array = {3,4,4,1,5,6,6};
        int key = 4;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0; i<array.length-1; i++){
            if (hashMap.containsKey(array[i]))
                hashMap.put(array[i], hashMap.get(array[i])+1);
            else
                hashMap.put(array[i], 1);
        }
        System.out.println(hashMap.get(key));
    }

    // sort an array of 0s, 1's, 2's
    static void sortArray0s1s2s(){
        int[] array = {0,1,1,0,1,2,1,2,0,0,0,1};
        int i, cnt0=0, cnt1=0, cnt2=0;
        for (i=0; i<array.length; i++){
            switch (array[i]){
                case 0:
                    cnt0++;
                    break;
                case 1:
                    cnt1++;
                    break;
                case 2:
                    cnt2++;
                    break;
            }
        }
        i=0; // update array
        while (cnt0>0){
            array[i] = 0;
            i++;
            cnt0--;
        }
        while (cnt1>0){
            array[i] = 1;
            i++;
            cnt1--;
        }
        while (cnt2>0){
            array[i] = 2;
            i++;
            cnt2--;
        }
        System.out.println(Arrays.toString(array));
    }

    // move all -ve elements to left side
    static void moveNegativeElementsLeftSide(){
        int[] array = {-1,2,-3,4,5,6,-7,8,9};
        int temp, j=0;
        for (int i=0; i<array.length; i++){
            if (array[i]<0){
                if (i!=j){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                j++;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    // move all zeroes to right
    static void moveAllZeroesToRight(){
        int[] array = {4,5,0,2,0,0};
        int[] temp = new int[array.length];
        int index = 0;
        for (int i=0; i<temp.length; i++){
            if (array[i] != 0){
                temp[index] = array[i];
                index++;
            }
        }
        while (index<array.length){
            temp[index] = 0;
            index++;
        }
        System.out.println(Arrays.toString(temp));
    }

    // cylindrically rotate array
    static void cylindricallyRotateArray(){
        int[] array = {1,2,3,4,5};
        int x = array[array.length-1]; // save last element
        for (int i=array.length-1; i>0; i--){
            array[i] = array[i-1];
        } // [1, 1, 2, 3, 4]
        array[0] = x; // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(array));
    }

    // find missing element
    static void findMissingElement(){
        int[] array = {1,2,3,5};
        int n = array.length; // array size
        int m = n+1; // actual size
        int total = m*(m+1)/2; // sum of int between 1 to n+1
        int sum = Arrays.stream(array).sum(); // get actual sum
        System.out.println("missing element: " + (total-sum));
    }

    // count pairs with given sum
    static void countPairsWithGivenSum(){
        int[] array = {1,5,7,-1,5};
        int sum = 6;
        int count = 0;
        for (int i=0; i<array.length; i++){
            for (int j=i+1; j<array.length; j++){
                if (array[i]+array[j] == sum)
                    count++;
            }
        }
        System.out.println(count);
    }

    // find duplicates in an array
    static void findDuplicatesInArray(){
        int[] array = {1,2,3,3,7,1,9,3};
        boolean duplicates = false;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0; i<array.length; i++){
            if (hashMap.containsKey(array[i]))
                hashMap.put(array[i], hashMap.get(array[i])+1);
            else
                hashMap.put(array[i], 1);
        }
        for (Map.Entry<Integer, Integer> entry: hashMap.entrySet()){
            if (entry.getValue()>1){
                System.out.print(entry.getKey()  + " ");
                duplicates = true;
            }
        }
        if (!duplicates)
            System.out.println("no duplicates present");
    }

    // find first repeating element in array
    static void findRepeatingElementInArray(){
        // reverse the loop then save the index, where repeating element occurs
        int[] array = {10,5,3,4,3,5,6};
        int min = -1;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i=array.length-1; i>=0; i--){
            if (hashSet.contains(array[i]))
                min = i;
            else
                hashSet.add(array[i]);
        }
        if (min!=-1)
            System.out.println("first repeating element: " + array[min]);
        else
            System.out.println("no repeating elements");
    }

    // find first non-repeating element in array
    static void findNonRepeatingElementInArray(){
        int[] array = {10,5,3,4,3,5,6};
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0; i<array.length; i++){
            if (hashMap.containsKey(array[i]))
                hashMap.put(array[i], hashMap.get(array[i])+1);
            else
                hashMap.put(array[i], 1);
        }
        for (int i=0; i<array.length; i++){
            if (hashMap.get(array[i]) == 1){
                System.out.println("first non-repeating: " + array[i]);
                break;
            }
        }
    }

    // find sub-array with sum 0
    static void subArrayWithSumZero(){
        int[] array = {4,2,-3,1,6};
        for (int i=0; i<array.length; i++){
            int sum = 0;
            for (int j=i; j<array.length; j++){
                sum += array[j];
                if (sum == 0)
                    System.out.println("sub-array [" + i + "..." + j + "]");
            }
        }
    }

    // largest sum contiguous sub-array
    static void largestSumContiguousSubArray(){
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        int max = array[0];
        int cur_max = array[0];
        for (int i=1; i<array.length; i++){
            cur_max  = Math.max(array[i], cur_max+array[i]);
            max = Math.max(max, cur_max);
        }
        System.out.println(max);
    }

    // factorial of large number
    static void factorialOfLargeNumber(){
        int N = 100;
        BigInteger integer = new BigInteger("1");
        for (int i=2; i<=N; i++){
            integer =  integer.multiply(BigInteger.valueOf(i));
        }
        System.out.println("factorial: " + integer);
    }

    // maximum product sub-array
    static void maxProductSubArray(){
        int[] array = {6,-3,-10,0,2};
        int n = array.length;
        int result = array[0];
        for (int i=0; i<n; i++){
            int mul = array[i];
            // traversing in current sub-array
            for (int j=i+1; j<n; j++){
                result =  Math.max(result, mul);
                mul *= array[j];
            }
            result = Math.max(result, mul);
            // 180 {6, -3, -10}
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        primeNumber();
    }

}
