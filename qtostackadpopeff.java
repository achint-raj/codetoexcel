//Queue to stack adapter pop efficient in java

import java.io.*;
import java.util.*;

class qtostackadpopeff
{
    public static class QtoStackAdapter
    {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QtoStackAdapter(){
        mainQ = new ArrayDeque<>();
        helperQ = new ArrayDeque<>();;
    }

    int size() {
      // write your code here
      return mainQ.size();
    }
    void push(int val) {
      // write your code here
      if(mainQ.size()==0){
        mainQ.add(val);
      }
      else{
        while(mainQ.size()>0){
            helperQ.add(mainQ.remove());
        }
        mainQ.add(val);
        while(helperQ.size()>0){
            mainQ.add(helperQ.remove());
        }
      }
    }
    int pop() {
      // write your code here
      if(mainQ.size() == 0){
        System.out.println("Stack underflow");
        return -1;
      }
      int val = mainQ.remove();
      return val;
    }
    int top() {
      // write your code here
      if(mainQ.size() == 0){
        System.out.println("Stack underflow");
        return -1;

      }
      int val = mainQ.peek();
      return val;
    }


    }
    public static void main(String args[]) throws Exception{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    QtoStackAdapter st = new QtoStackAdapter();
    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      }
      str = br.readLine();
    }
}
    
}