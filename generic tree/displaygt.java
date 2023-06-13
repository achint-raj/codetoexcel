import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;




class displaygt {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static void display(Node node){
        String str = node.data + " -> ";
        for(Node child : node.children){
        str += child.data + " , ";
        }
        str += " .";
        System.out.println(str);
    for (Node child : node.children) {
      display(child);
    }
    }
      public static Node construct(int[] arr) {
    Node root = null;
    Stack< Node> st = new Stack< >();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      }
      else {
        Node t = new Node();
        t.data = arr[i];
        if (st.size() > 0) {
          st.peek().children.add(t);
        }
        else {
          root = t;
        }
        st.push(t);
      }
    }
    return root;
  }
    public static void main(String args[]){
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int arr[] = new int[n];
       String[] values = in.next().split(" "); 
      for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }
    Node root = construct(arr);                
    display(root);                                              
    in.close();
    }
}