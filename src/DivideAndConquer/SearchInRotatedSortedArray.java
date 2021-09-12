package DivideAndConquer;

public class SearchInRotatedSortedArray {
    // return index of key
    static int search(int[] array, int low, int high, int key){
        if (low>high)
            return -1;
        int mid = (low+high)/2;
        // result
        if (array[mid] == key)
            return mid;
        // if arr[low..mid] first sub-array is sorted
        if (array[low]<=array[mid]){
            /* as sub-array is sorted we can quickly check,
            if key lies in half or other half */
            if (key>=array[low] && key<=array[mid]) {
                return search(array, low, mid - 1, key);
            }
            /* if key not lies in first half sub-array, divide
            other half into two sub-arrays. such that we can
            quickly check if key lies in other half */
            return search(array, mid+1, high, key);
        }
        /* if arr[low..mid] first sub-array is not sorted,
        then arr[mid..high] must be sorted sub-array */
        if (key>=array[mid] && key<=array[high]) {
            return search(array, mid + 1, high, key);
        }
        return search(array, low, mid-1, key);
    }
    public static void main(String[] args){
        int[] array = {4,5,6,7,0,1,2,3};
        int n = array.length-1;
        int key = 2;
        int i = search(array, 0, n-1, key);
        if (i!=-1){
            System.out.println("index " + i);
        }else {
            System.out.println("key not found");
        }
    }
}
