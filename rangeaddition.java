// 1. Assume you have an array of length 'n' initialized with all 0's and are given 'q' queries to update.
// 2. Each query is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
// 3. Return the modified array after all 'q' queries were executed.
// Input Format
// length = 5,
// updates = 
// {
//     {1,  3,  2},
//     {2,  4,  3},
//     {0,  2, -2}
// }
// Output Format
// return {-2, 0, 3, 5, 3}
// Explanation : 
// Initial state:
// { 0, 0, 0, 0, 0 }
// After applying operation [1, 3, 2]:
// { 0, 2, 2, 2, 0 }
// After applying operation [2, 4, 3]:
// { 0, 2, 5, 5, 3 }
// After applying operation [0, 2, -2]:
// {-2, 0, 3, 5, 3 }

import java.util.*;
class rangeaddition {
    public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    int n=in.nextInt();
    
    int nq = in.nextInt();
        
    int[][] queries = new int[nq][3];

    for(int q = 0; q < nq; q++) {
        queries[q][0] = in.nextInt();
        queries[q][1] = in.nextInt();
        queries[q][2] = in.nextInt();
    }
    int res[] = getmodifiedarray(n,queries);
    for(int i = 0; i < res.length; i++) {
        System.out.print(res[i] + " ");
    }
    }
    public static int[] getmodifiedarray(int n,int queries[][]){
        int res[]=new int[n];
        for(int q=0;q<queries.length;q++){   //proviving impact to res
            int st = queries[0][0];
            int end = queries[0][1];
            int inc = queries[0][2];
            res[st] = res[st]+inc;
            if(end < n){
                res[end+1]-=inc;
            }

        }
        int sum=0;
        for(int i=0;i<res.length;i++){
            sum+=res[i];
            res[i]=sum;
        }
        return res;
    }
}