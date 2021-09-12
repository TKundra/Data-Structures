package Arrays;

public class InversionOfArray {

    static int brute(int[] array, int n){
        int c = 0;
        for (int i=0; i<n-1; i++){
            for (int j=i+1; j<n; j++){
                if (array[i]>array[j]){
                    c++;
                }
            }
        }
        return c;
    }

    static int merge(int[] array, int start, int mid, int end){
        int i = start, j = mid+1, p, index = start;
        int[] temp = new int[array.length];
        int count = 0;
        /* both partitions to compare and store in array*/
        while (i<=mid && j<=end){
            if (array[i] < array[j]){
                temp[index] = array[i];
                i+=1;
            }else {
                temp[index] = array[j];
                j+=1;
                // ar[i] > ar[j] and i<j
                count+=(mid-i+1);
            }
            index++;
        }
        /* when some elements left in sub-tree */
        if (i>mid){
            while (j<=end){
                temp[index] = array[j];
                index++;
                j++;
            }
        }else {
            while (i<=mid){
                temp[index] = array[i];
                index++;
                i++;
            }
        }
        /* copy whole data from temp array to original array */
        p = start;
        while (p<index){
            array[p] = temp[p];
            p++;
        }
        return count;
    }
    static int sort(int[] array, int start, int end){
        int mid;
        int count = 0;
        if (start<end){
            mid = (start+end)/2;
            /* split till one element is left */
            count+=sort(array, start, mid);
            count+=sort(array, mid+1, end);
            /* to merge */
            count+=merge(array, start, mid, end);
        }
        return count;
    }

    public static void main(String[] args){
        int[] array = {3,5,2,1,8,6,4,9};
        System.out.println(sort(array, 0,array.length-1));
    }
}

//    static int mergeAndCount(int[] array, int[] temp, int start, int mid, int end){
//        int i = start, j = mid, index = start, p;
//        int count = 0;
//        while (i<=mid-1 && j<=end){
//            if (array[i] <= array[j]){
//                temp[index] = array[i];
//                i+=1;
//                index++;
//            }else {
//                temp[index] = array[j];
//                j+=1;
//                index++;
//                count += (mid-i);
//            }
//        }
//        while (i<=mid-1){
//            temp[index] = array[i];
//            index++;
//            i++;
//        }
//        while (j<=end){
//            temp[index] = array[j];
//            index++;
//            j++;
//        }
//        for (i=start; i<=end; i++){
//            array[i] = temp[i];
//        }
//        return count;
//    }
//    static int mergeSortAndCount(int[] array, int[] temp, int left, int right){
//        int count = 0;
//        if (left<right){
//            int mid = (left+right)/2;
//            // left sub-array count
//            count += mergeSortAndCount(array,temp,left,mid);
//            // right sub-array count
//            count += mergeSortAndCount(array,temp,mid+1,right);
//            // merge count
//            count += mergeAndCount(array,temp,left,mid+1,right);
//        }
//        return count;
//    }
//    static int mergeSortAndCount(int[] array, int n){
//        int[] temp = new int[n];
//        return mergeSortAndCount(array,temp,0,n-1);
//    }
