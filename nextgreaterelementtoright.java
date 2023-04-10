import java.io.*;
import java.util.*;
class nextgreaterelementtoright
{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
    System.out.println("Enter the length of the array:");
    int n = in.nextInt();
    System.out.println("enter the array elements");
    int arr[]=new int[n];
    for(int i=0;i<n;i++){
        arr[i]=in.nextInt();
    }
    int nge[] = ngetr(arr);
    display(nge);
  
    }
    public static int[] ngetr(int arr[]){
    int nge[]=new int[arr.length];
    nge[arr.length-1] = -1;
    Stack<Integer> st = new Stack<>();
    st.push(arr[arr.length-1]);
    for(int i=arr.length-2;i>=0;i--){
        while(st.size()>0 && arr[i]>=st.peek()){
            st.pop();
        }
        if(st.size() == 0){
            nge[i]=-1;
        }
            else{
                nge[i]=st.peek();
            }
        st.push(arr[i]);
        }
        return nge;
    }
    

    public static void display(int arr[]){
        StringBuilder sb = new StringBuilder();
        for(int val:arr)
        sb.append(val + "\n");
        System.out.println(sb);
        }

    }

