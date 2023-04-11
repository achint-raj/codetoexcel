//solving binary search recursively

import java.util.*;
class binarysearchrec {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        int k =in.nextInt();
        int binsrch = binarysearch(arr,0,n-1,k);
        System.out.println(binsrch);
    }
    public static int binarysearch(int arr[], int low, int high, int k){
        if(low<=arr.length-1 && high>=low){
        int mid = (low+high)/2;
        if(arr[mid] == k)
        return mid;
        else if(k < arr[mid]){
        return binarysearch(arr, low, mid-1, k);
        }
        else if(k>arr[mid])
        {
        return binarysearch(arr, mid+1, high, k);
        }
    }
        return -1;
        
    }
}