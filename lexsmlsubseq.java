// lexicographically smallest subsequence pepcoding and gfg(little different on gfg but same concept)

import java.util.*;
public class lexsmlsubseq {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();
        int ans[] = solve(arr, k);
        System.out.println("Array length"+ans.length);
        for(int a:ans)
        System.out.println(a);

    }
    public static int[] solve(int arr[], int k){
        int n =arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(st.size()>0 && st.peek() > arr[i] && n-i-1 >= k-st.size()){  //valid and smaller condition handled
                st.pop();
            }
            if(st.size() < k)
            st.push(arr[i]);
        //st.push(arr[i]);
        }
        int ans[] = new int[k];
        int i=k-1;
        while(i>=0){
            ans[i]=st.pop();
            i--;
        }
    return ans;
    }
}
