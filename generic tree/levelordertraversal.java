import java.io.*;
import java.util.*;

public class levelordertraversal {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
  }

  public static int max(Node node) {
    int m = Integer.MIN_VALUE;

    for (Node child : node.children) {
      int cm = max(child);
      m = Math.max(m, cm);
    }
    m = Math.max(m, node.data);

    return m;
  }

  public static int height(Node node) {
    int h = -1;

    for (Node child : node.children) {
      int ch = height(child);
      h = Math.max(h, ch);
    }
    h += 1;

    return h;
  }

  public static void traversals(Node node){
    System.out.println("Node Pre " + node.data);

    for(Node child: node.children){
      System.out.println("Edge Pre " + node.data + "--" + child.data);
      traversals(child);
      System.out.println("Edge Post " + node.data + "--" + child.data);
    }

    System.out.println("Node Post " + node.data);
  }
// write code for below section 
  public static void levelOrder(Node node){
    // write your code here
    //we will use Queue data structure this time for this and our rule will be RPA i.e. remove,print ,add
    Queue<Node> que = new ArrayDeque<>();
    que.add(node);
    while(que.size()>0){
        node = que.remove();
        System.out.println(node.data+ " ");
        for(Node child:node.children){
            que.add(child);
        }
    }
    System.out.println(".");

  }

  public static void levelorderlinewise(Node node){
    Queue<Node> que = new ArrayDeque<>();
    Queue<Node> cque = new ArrayDeque<>();
    que.add(node);
    while(que.size()>0){
        node = que.remove();
        System.out.print(node.data + " ");
        for(Node child:node.children){
            cque.add(child);
        }
        if(que.size() == 0){
            que = cque;
            cque = new ArrayDeque<>();
            System.out.println();
        }
    }
  }
  public static boolean find(Node node, int data){
    if(node.data == data)
    return true;
    for(Node child:node.children){
      boolean fic = find(child,data);
      if(fic){
      return true;
      }
    }
    return false;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    int data = Integer.parseInt(br.readLine());
    //levelOrder(root);
    //levelorderlinewise(root);
    System.out.println(find(root,data));

  }

}