package DivideAndConquer;

// using Binary Search
public class ElementAppearOnceSortedArray {
    static void search(int[] array, int low, int high){
        // base conditions
        if (low>high){
            return;
        }
        // if low == high, result array[low]
        if (low==high){
            System.out.println("required element: " + array[low]);
            return;
        }
        // find mid
        int mid = (low+high)/2;
        /* if mid is even and element next to mid is same as mid,
        then output element lies on right side, else on left side */
        if (mid%2==0){
            if (array[mid] == array[mid+1])
                search(array,mid+2,high);
            else
                search(array,low,mid);
        }
        /* if mid is odd and element previous to mid is same as mid,
        then output element lies on right side, else on left side */
        else if (mid%2==1){
            if (array[mid]==array[mid-1])
                search(array,mid+1,high);
            else
                search(array,low,mid-1);
        }
    }
    public static void main(String[] args){
        int[] array = {1,1,2,4,4,5,5,6,6};
        search(array,0,array.length-1);
    }
}
